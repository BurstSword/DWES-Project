package com.restaurant.restaurant.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity used in Cart class
 */
@Data
@NoArgsConstructor @AllArgsConstructor
public class CartItem {
    private int id;
    private int quantity;


}
