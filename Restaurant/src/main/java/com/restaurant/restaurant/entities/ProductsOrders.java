package com.restaurant.restaurant.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "products_orders")
public class ProductsOrders {

    @EmbeddedId
    private ProductOrderId id = new ProductOrderId();

    @ManyToOne
    @MapsId("productId")
    private Products products;

    @ManyToOne
    @MapsId("orderId")
    private Orders orders;

    @Column(name = "units")
    private int units;


}
