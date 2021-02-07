package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Categories;
import com.restaurant.restaurant.entities.Products;
import com.restaurant.restaurant.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<Products> getProductList() {
        return null;
    }

    @Override
    public List<Categories> getCategoryList() {
        return (List<Categories>) categoryRepository.findAll();
    }
}
