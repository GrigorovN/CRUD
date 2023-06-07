package com.example.module16homework.convertor;

import com.example.module16homework.dto.UserRequest;
import com.example.module16homework.dto.UserResponse;
import com.example.module16homework.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toUSer(UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User savedUser){

        return new UserResponse(savedUser.getFirstName(), savedUser.getLastName(), savedUser.getEmail());
    }
}
