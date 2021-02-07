package com.restaurant.restaurant.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

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
    @Pattern(regexp = "^([0-9]{5})$")
    private String cp;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Orders> ordersList=new ArrayList<>();
}
