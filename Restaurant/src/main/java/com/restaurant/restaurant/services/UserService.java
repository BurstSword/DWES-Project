package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.*;
//import com.restaurant.restaurant.entities.ProductOrders;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<Products> getProductList();
    List<Categories> getCategoryList();
    //void saveProductOrder(ProductOrders productOrders);
    void saveOrder(Orders orders);
    List<ProductsOrders> getProductOrders(Collection<Integer> id);
    Optional<Restaurant> getRestaurant(Restaurant restaurant);
}
