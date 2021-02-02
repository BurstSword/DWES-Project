package com.restaurant.restaurant.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdmId")
    private int admId;

    @Column(name = "Mail")
    @Length(min = 1, max = 45, message = "Entre 0 y 45 caracteres")
    @NotNull(message = "is required")
    private String mail;

    @Column(name = "Pwd")
    private String dni;

}
