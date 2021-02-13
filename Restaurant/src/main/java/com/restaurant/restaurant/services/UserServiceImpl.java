package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Categories;
import com.restaurant.restaurant.entities.Orders;
//import com.restaurant.restaurant.entities.ProductOrders;
import com.restaurant.restaurant.entities.Products;
import com.restaurant.restaurant.entities.ProductsOrders;
import com.restaurant.restaurant.repositories.CategoryRepository;
import com.restaurant.restaurant.repositories.OrderRepository;
//import com.restaurant.restaurant.repositories.ProductOrdersRepository;
import com.restaurant.restaurant.repositories.ProductsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CategoryRepository categoryRepository;
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

}
