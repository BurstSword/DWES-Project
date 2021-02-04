package com.restaurant.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrdId")
    private int ordId;

    @Column(name = "vDate")
    @Length(min = 1, max = 45, message = "Entre 0 y 45 caracteres")
    @NotNull(message = "is required")
    private Date vDate;

    @Column(name = "Sent")
    private int sent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Restaurant")
    private int restaurant;
}
