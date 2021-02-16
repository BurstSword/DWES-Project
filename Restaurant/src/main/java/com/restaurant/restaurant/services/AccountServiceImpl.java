package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Restaurant;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public int register(Restaurant restaurant) {

        boolean correctRestaurant=Utilities.checkRestaurantRegister(restaurant);
        if(!correctRestaurant){
            return 0;
        }
        if (restaurantRepository.existsRestaurantByMail(restaurant.getMail())) {
            return 1;
        }
        restaurantRepository.save(restaurant);

        return 2;
    }


    public int login(Restaurant restaurant){

        Optional<Restaurant> restaurantOptional = restaurantRepository.findByMail(restaurant.getMail());

        if(restaurantOptional.isPresent()){

            if(restaurantOptional.get().getPwd().equals(restaurant.getPwd())){
                return 1;
            }
        }
        return 0;
    }


}
