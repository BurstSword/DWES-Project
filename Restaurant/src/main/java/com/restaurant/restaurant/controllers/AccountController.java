package com.restaurant.restaurant.controllers;


import com.restaurant.restaurant.entities.Admin;
import com.restaurant.restaurant.entities.Restaurant;
import com.restaurant.restaurant.repositories.AdminRepository;
import com.restaurant.restaurant.repositories.RestaurantRepository;
import com.restaurant.restaurant.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    AdminRepository adminRepository;


    @PostMapping("/loginRestaurant")
    public ResponseEntity<Restaurant> loginRestaurant(@RequestBody Restaurant restaurant) {

        int databaseResponse = accountService.login(restaurant);

        switch (databaseResponse) {
            case 0:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            case 1:
                Restaurant restaurant1 = restaurantRepository.findByMail(restaurant.getMail()).get();
                return new ResponseEntity<>(restaurant1, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<Admin> loginRestaurant(@RequestBody Admin admin) {

        int databaseResponse = accountService.login(admin);

        switch (databaseResponse) {
            case 0:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            case 1:
                Admin admin1 = adminRepository.findByMail(admin.getMail()).get();
                return new ResponseEntity<>(admin1, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/registerRestaurant")
    public ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant) {

        int databaseResponse = accountService.register(restaurant);

        switch (databaseResponse) {
            case 0:
                return ResponseEntity.badRequest().body(400);
            case 1:
                return ResponseEntity.badRequest().body(409);
            case 2:
                return ResponseEntity.ok(200);
        }

        return ResponseEntity.badRequest().body(500);
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {

        int databaseResponse = accountService.register(admin);

        switch (databaseResponse) {
            case 0:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            case 1:
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            case 2:
                return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
