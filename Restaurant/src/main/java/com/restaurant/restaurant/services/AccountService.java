package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Admin;
import com.restaurant.restaurant.entities.Restaurant;

public interface AccountService {

     int register(Admin admin);
     int register(Restaurant restaurant);
     int login (Admin admin);
     int login (Restaurant restaurant);
}
