package com.restaurant.restaurant.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Restaurant table from database
 */
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail",unique=true)
    private String mail;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "address")
    private String address;

    @Column(name = "cp")
    private String cp;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "restaurant")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private List<Orders> ordersList=new ArrayList<>();
}
