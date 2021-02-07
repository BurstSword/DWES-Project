package com.restaurant.restaurant.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(value= AccessLevel.NONE)
    private int id;

    @Column(name = "mail")
    @NotBlank
    private String mail;

    @Column(name = "pwd")
    @NotBlank
    private String pwd;

}
