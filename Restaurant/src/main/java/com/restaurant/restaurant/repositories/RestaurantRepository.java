package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Restaurant repository to operate with Restaurant table
 */
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {


    /**
     * Check if and email exists or not in database
     * @param mail
     * @return
     */
    Boolean existsRestaurantByMail(String mail);

    /**
     * Search a restaurant using a specific email
     * @param mail
     * @return
     */
    Optional<Restaurant> findByMail(String mail);
}
