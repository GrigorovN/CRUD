package com.example.module16homework.service.impl;

import com.example.module16homework.convertor.CarConverter;
import com.example.module16homework.dto.CarRequest;
import com.example.module16homework.dto.CarResponse;
import com.example.module16homework.entity.Car;
import com.example.module16homework.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarConverter carConverter;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarConverter carConverter, CarRepository carRepository) {
        this.carConverter = carConverter;
        this.carRepository = carRepository;
    }

    @Override
    public CarResponse saveCar(CarRequest request) {
        Car car = carConverter.toCar(request);
        Car savedCar = carRepository.save(car);

        return carConverter.toResponse(savedCar);
    }

    @Override
    public CarResponse getCar(Long id) {
        Car car = carRepository.findById(id).get();

        return carConverter.toResponse(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
