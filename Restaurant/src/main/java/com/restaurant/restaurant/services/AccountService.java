package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Restaurant;

/**
 * Service interface for authentication control
 */
public interface AccountService {
     int register(Restaurant restaurant);
     int login (Restaurant restaurant);
}
