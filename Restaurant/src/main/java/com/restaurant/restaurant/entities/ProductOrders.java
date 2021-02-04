package com.restaurant.restaurant.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "productorders")
public class ProductOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdOrderId")
    private int prodOrderId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vOrder")
    private Date vOrder;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Product")
    private int product;


    @JoinColumn(name = "Units")
    private int units;
}
