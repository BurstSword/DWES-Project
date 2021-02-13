package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Categories;
import com.restaurant.restaurant.entities.Orders;
//import com.restaurant.restaurant.entities.ProductOrders;
import com.restaurant.restaurant.entities.Products;
import com.restaurant.restaurant.entities.ProductsOrders;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<Products> getProductList();
    List<Categories> getCategoryList();
    //void saveProductOrder(ProductOrders productOrders);
    void saveOrder(Orders orders);
    List<ProductsOrders> getProductOrders(int id);
}
