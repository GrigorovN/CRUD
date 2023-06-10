package com.example.module16homework.service.impl;

import com.example.module16homework.convertor.UserConverter;
import com.example.module16homework.dto.UserRequest;
import com.example.module16homework.dto.UserResponse;
import com.example.module16homework.entity.User;
import com.example.module16homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse saveUser(UserRequest request) {
        User user = userConverter.toUSer(request);

        User savedUser = userRepository.save(user);

        return userConverter.toResponse(savedUser);
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).get();
        return userConverter.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();

        if (Objects.nonNull(request.getFirstName()) && !request.getFirstName().isBlank()){
            user.setFirstName(request.getFirstName());
        }
        if (Objects.nonNull(request.getLastName()) && !request.getLastName().isBlank()){
            user.setLastName(request.getLastName());
        }
        if (Objects.nonNull(request.getEmail()) && !request.getEmail().isBlank()){
            user.setEmail(request.getEmail());
        }
        if (Objects.nonNull(request.getPassword()) && !request.getPassword().isBlank()){
            user.setPassword(request.getPassword());
        }
        return userConverter.toResponse(userRepository.save(user));
    }

}
