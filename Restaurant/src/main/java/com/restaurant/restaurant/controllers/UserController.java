package com.restaurant.restaurant.controllers;

import com.restaurant.restaurant.entities.*;
//import com.restaurant.restaurant.entities.ProductOrders;
import com.restaurant.restaurant.repositories.ProductRepository;
import com.restaurant.restaurant.repositories.ProductsOrdersRepository;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.services.EmailPort;
import com.restaurant.restaurant.services.EmailService;
import com.restaurant.restaurant.services.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Controller in charge of receiving and sending the indicated information to buy products, see the categories etc
 */
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductsOrdersRepository productsOrdersRepository;
    @Autowired
    private EmailPort emailPort;


    /**
     * Method in charge of sending the categories from database to client.
     * @return HTTP Response type and the category list
     */
    @GetMapping("/categoryList")
    public ResponseEntity<List<Categories>> getCategoryList() {

        List<Categories> categoriesList = userService.getCategoryList();

        return new ResponseEntity<>(categoriesList, HttpStatus.OK);
    }


    /**
     * Method in charge of receiving orders id and sending the products associated to them.
     * @param id The orders id
     * @return HTTP Response type and the product list
     */
    @PostMapping("/getOrders")
    public ResponseEntity<List<ProductsOrders>> getOrders(@RequestBody Collection<Integer> id) {

        List<ProductsOrders> productsOrdersList = userService.getProductOrders(id);

        return new ResponseEntity<>(productsOrdersList, HttpStatus.OK);
    }

    /**
     * Method in charge of saving the orders from the restaurant
     * @param cart The products received from client
     * @return HTTP Response type
     */
    @PostMapping("/saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody Cart cart) {
        String order = "";
        Orders orders = new Orders();
        Optional<Restaurant> restaurants = restaurantRepository.findById(cart.getRestaurant_id());
        if(restaurants.isEmpty()){
            return ResponseEntity.badRequest().body("415");
        }
        //Creating the order
        Restaurant restaurant = restaurants.get();
        orders.setRestaurant(restaurant);
        Date sqlDate = new Date(new java.util.Date().getTime());
        orders.setV_Date(sqlDate);
        orders.setSent(0);

        List<Products> productsList = productRepository.findAllByIdInOrderByIdAsc(cart.getCartItems().stream().map(CartItem::getId).collect(Collectors.toList()));

        //Creating the productOrder
        Collections.sort(cart.getCartItems(), Comparator.comparingInt(CartItem::getId));
        for (int i = 0; i < cart.getCartItems().size(); i++) {
            order+="Product: "+productsList.get(i).getName()+" Units: "+cart.getCartItems().get(i).getQuantity()+"<br>";
            productRepository.save(productsList.get(i));
            ProductsOrders productsOrders = new ProductsOrders();
            productsOrders.setOrders(orders);
            productsList.get(i).setStock(productsList.get(i).getStock()-cart.getCartItems().get(i).getQuantity());
            if(productsList.get(i).getStock()<0){
                return ResponseEntity.badRequest().body("416");
            }else{
                productRepository.save(productsList.get(i));
                productsOrders.setProducts(productsList.get(i));
                userService.saveOrder(orders);
                productsOrders.setUnits(cart.getCartItems().get(i).getQuantity());
                productsOrdersRepository.save(productsOrders);

            }

        }

        emailPort.sendEmail(new EmailBody(restaurant.getMail(),order,"Order nº "+ orders.getId()));


        return ResponseEntity.ok("200");
    }

    /**
     * Method in charge of sending a restaurant
     * @param restaurant Credentials for the restaurant to identify it easily
     * @return HTTP Response type and the restaurant
     */
    @PostMapping("/getRestaurant")
    public ResponseEntity<List<ProductsOrders>> getOrders(@RequestBody Restaurant restaurant) {

        Restaurant restaurant1 = userService.getRestaurant(restaurant).get();

        return new ResponseEntity(restaurant1, HttpStatus.OK);
    }

}
