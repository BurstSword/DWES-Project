package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CatId")
    private int catId;

    @Column(name = "Name")
    @Length(min = 1, max = 45, message = "Entre 0 y 45 caracteres")
    @NotNull(message = "is required")
    private String name;

    @Column(name = "Description")
    private String description;
}
