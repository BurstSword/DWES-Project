package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.*;
//import com.restaurant.restaurant.entities.ProductOrders;
import com.restaurant.restaurant.repositories.CategoryRepository;
import com.restaurant.restaurant.repositories.OrderRepository;
//import com.restaurant.restaurant.repositories.ProductOrdersRepository;
import com.restaurant.restaurant.repositories.ProductsOrdersRepository;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Service used to interact with categories, restaurant and products
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ProductsOrdersRepository productOrdersRepository;
    @Autowired
    OrderRepository orderRepository;

    /**
     * Returns the product list
     * @return
     */
    @Override
    public List<Products> getProductList() {
        return null;
    }

    /**
     * Return the category list with its products
     * @return
     */
    @Override
    public List<Categories> getCategoryList() {
        return (List<Categories>) categoryRepository.findAll();
    }


    /**
     * Save orders
     * @param orders
     */
    @Override
    public void saveOrder(Orders orders) {
        orderRepository.save(orders);
    }

    /**
     * Return a Product Orders list with orders id
     * @param id Orders id
     * @return Product orders list
     */
    @Override
    public List<ProductsOrders> getProductOrders(Collection<Integer> id) {
        return productOrdersRepository.findAllByOrders_IdIn(id);
    }

    /**
     * Return a restaurant using his id
     * @param restaurant
     * @return a Restaurant entity
     */
    @Override
    public Optional<Restaurant> getRestaurant(Restaurant restaurant) {
        return restaurantRepository.findById(restaurant.getId());
    }


}
