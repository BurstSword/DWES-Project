package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class ProductOrderId implements Serializable {
    private int productId;
    private int orderId;
}
