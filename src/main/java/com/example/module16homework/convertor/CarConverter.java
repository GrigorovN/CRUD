package com.example.module16homework.convertor;

import com.example.module16homework.dto.CarRequest;
import com.example.module16homework.dto.CarResponse;
import com.example.module16homework.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car toCar(CarRequest request) {
        return Car.builder()
                .brand(request.getBrand())
                .vin(request.getVin())
                .model(request.getModel())
                .registration(request.getRegistration())
                .build();
    }

    public CarResponse toResponse(Car savedCar){
        return new CarResponse(savedCar.getBrand(),savedCar.getModel(),savedCar.getRegistration());
    }
}
