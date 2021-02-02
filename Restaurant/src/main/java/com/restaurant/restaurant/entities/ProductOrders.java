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
    @Column(name = "ProdOrder")
    private int prodOrder;

    @JoinColumn(name = "vOrder")
    private Date vDate;

    @JoinColumn(name = "Product")
    private int product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Units")
    private int restaurant;
}
