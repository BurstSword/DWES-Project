package com.restaurant.restaurant.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResId")
    private int resId;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "Pwd")
    private String password;

    @Column(name = "Address")
    private String address;

    @Column(name = "CP")
    private int cp;

    @Column(name = "Country")
    private int country;

    @Column(name = "City")
    private int city;
}
