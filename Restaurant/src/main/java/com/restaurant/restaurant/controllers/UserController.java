package com.restaurant.restaurant.controllers;

import com.restaurant.restaurant.entities.Categories;
import com.restaurant.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/categoryList")
    public ResponseEntity<List<Categories>> getCategoryList(){

        List<Categories> categoriesList = userService.getCategoryList();

        return new ResponseEntity<>(categoriesList,HttpStatus.OK);
    }
}
