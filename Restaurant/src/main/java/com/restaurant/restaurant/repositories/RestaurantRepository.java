package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {



    Boolean existsRestaurantByMail(String mail);

    Optional<Restaurant> findByMail(String mail);
}
