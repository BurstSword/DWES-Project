package com.restaurant.restaurant.services;

import com.restaurant.restaurant.entities.Admin;
import com.restaurant.restaurant.entities.Restaurant;
import com.restaurant.restaurant.repositories.AdminRepository;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AdminRepository adminRepository;
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


    public int register(Admin admin) {

        boolean correctAdmin=Utilities.checkAdminRegister(admin);

        if(!correctAdmin){
            return 0;
        }
        if (adminRepository.existsAdminByMail(admin.getMail())) {
            return 1;
        }

        adminRepository.save(admin);
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

    public int login(Admin admin){

        Optional<Admin> adminOptional = adminRepository.findByMail(admin.getMail());

        if(adminOptional.isPresent()){
            if(adminOptional.get().getPwd().equals(admin.getPwd())){
                return 1;
            }
        }
        return 0;
    }
}
