package com.restaurant.restaurant.utils;

import com.restaurant.restaurant.entities.Admin;
import com.restaurant.restaurant.entities.Restaurant;

public class Utilities {


    public static boolean checkRestaurantRegister(Restaurant restaurant) {

        return !checkStringNullOrEmpty(restaurant.getMail(), restaurant.getAddress(), restaurant.getCity(), restaurant.getCountry(), restaurant.getCp(), restaurant.getPwd());
    }

    public static boolean checkAdminRegister(Admin admin){
        return !checkStringNullOrEmpty(admin.getMail(), admin.getPwd());
    }

    //Check if string are null or empty
    //If any string is null or empty returns true
    //otherwise, returns false
    public static boolean checkStringNullOrEmpty(String... strings) {
        for (String string :
                strings) {
            if (string == null || string.isEmpty()) {
            return true;
            }
        }
        return false;
    }
}
