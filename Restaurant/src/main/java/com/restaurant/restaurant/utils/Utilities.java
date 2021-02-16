package com.restaurant.restaurant.utils;

import com.restaurant.restaurant.entities.Restaurant;

/**
 * Class for utilities
 */
public class Utilities {

    /**
     * Util to check restaurant values
     * @param restaurant restaurant to check
     * @return A boolean depending if restaurant is valid or not
     */
    public static boolean checkRestaurantRegister(Restaurant restaurant) {

        return !checkStringNullOrEmpty(restaurant.getMail(), restaurant.getAddress(), restaurant.getCity(), restaurant.getCountry(), restaurant.getCp(), restaurant.getPwd());
    }

    //Check if strings are null or empty
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
