package com.restaurant.restaurant.controllers;


import com.restaurant.restaurant.entities.Restaurant;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * This controller receives and sends petitions refered to login and register stuff
 */
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    RestaurantRepository restaurantRepository;

    /**
     * Method in charge of receiving the login credentials, validate them and send a response to client.
     * @param restaurant The restaurant who has logged in
     * @return HTTP Response type
     */
    @PostMapping("/loginRestaurant")
    public ResponseEntity<?> loginRestaurant(@RequestBody Restaurant restaurant) {

        int databaseResponse = accountService.login(restaurant);

        switch (databaseResponse) {
            case 0:
                return ResponseEntity.badRequest().body(400);
            case 1:
                Restaurant restaurant1 = restaurantRepository.findByMail(restaurant.getMail()).get();
                return  ResponseEntity.ok(restaurant1);
        }

        return ResponseEntity.badRequest().body(500);
    }


    /**
     * Method in charge of receiving the register credentials, validate them and send a response to client.
     * @param restaurant The restaurant who wants to register.
     * @return HTTP Response type
     */
    @PostMapping("/registerRestaurant")
    public ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant) {

        int databaseResponse = accountService.register(restaurant);

        switch (databaseResponse) {
            case 0:
                return ResponseEntity.badRequest().body(400);
            case 1:
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            case 2:
                return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(500);
    }


}
