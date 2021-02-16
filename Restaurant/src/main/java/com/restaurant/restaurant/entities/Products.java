package com.restaurant.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Products table from database
 */
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private int price;

    @ManyToOne//(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Categories categories;


    @ManyToMany
    @JoinTable(name = "products_orders",
    joinColumns = {@JoinColumn(name = "products_id")})
    @JsonBackReference(value="product-order")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Set<Orders> orders;


}
