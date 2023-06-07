package com.example.module16homework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "cars")
public class Car {
//Car трябва да има следните атрибути:


//vin
//регистрационен номер
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 35)
    private String brand;

    @Column(length = 35)
    private String model;

    @Column(length = 35, unique = true)
    private String vin;
    @Column(length = 35, unique = true)
    private String registration;

    @ManyToOne
    @JsonBackReference
    private User user;
}
