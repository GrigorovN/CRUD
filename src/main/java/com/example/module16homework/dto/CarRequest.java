package com.example.module16homework.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    @Length(min =5)
    private String vin;
    @NotBlank
    @Length(min =5)
    private String registration;


}
