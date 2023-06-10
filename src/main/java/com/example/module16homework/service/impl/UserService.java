package com.example.module16homework.service.impl;

import com.example.module16homework.dto.UserRequest;
import com.example.module16homework.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse saveUser(UserRequest request);

    UserResponse getUser(Long id);

    void deleteUser(Long id);

    UserResponse updateUser(Long id, UserRequest request);
}
