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

    @Override
    public List<Products> getProductList() {
        return null;
    }

    @Override
    public List<Categories> getCategoryList() {
        return (List<Categories>) categoryRepository.findAll();
    }

    /*@Override
    public void saveProductOrder(ProductOrders productOrders) {
        System.out.println(productOrders.toString());
        productOrdersRepository.save(productOrders);
    }*/

    @Override
    public void saveOrder(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public List<ProductsOrders> getProductOrders(Collection<Integer> id) {
        return productOrdersRepository.findAllByOrders_IdIn(id);
    }

    @Override
    public Optional<Restaurant> getRestaurant(Restaurant restaurant) {
        return restaurantRepository.findById(restaurant.getId());
    }


}
