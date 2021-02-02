package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdId")
    private int prodId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private int description;

    @Column(name = "Weight")
    private int Weight;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "Price")
    private int price;

    @JoinColumn(name = "Category")
    private int category;
}
