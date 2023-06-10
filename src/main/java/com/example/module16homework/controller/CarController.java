package com.example.module16homework.controller;

import com.example.module16homework.dto.CarRequest;
import com.example.module16homework.dto.CarResponse;
import com.example.module16homework.dto.UserRequest;
import com.example.module16homework.dto.UserResponse;
import com.example.module16homework.entity.Car;
import com.example.module16homework.service.impl.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(path = "/register")
    public ResponseEntity<CarResponse> registerUser(@Valid @RequestBody CarRequest request) {
        CarResponse response = carService.saveCar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<CarResponse> getUser(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.FOUND).body(carService.getCar(id));
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        carService.deleteCar(id);
        return HttpStatus.ACCEPTED;
    }

}
