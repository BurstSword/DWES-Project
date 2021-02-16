package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class used to storage the cart from client
 */
@Data
@NoArgsConstructor @AllArgsConstructor
public class Cart {
    private int restaurant_id;
    private List<CartItem> cartItems;
}
