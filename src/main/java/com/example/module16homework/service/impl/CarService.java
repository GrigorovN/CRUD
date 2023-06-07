package com.example.module16homework.service.impl;

import com.example.module16homework.dto.CarRequest;
import com.example.module16homework.dto.CarResponse;
import org.springframework.stereotype.Service;

@Service
public interface CarService {

    CarResponse saveUser(CarRequest request);

    CarResponse getCar(Long id);

    void deleteCar(Long id);
}
