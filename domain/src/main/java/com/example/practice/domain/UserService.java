package com.example.practice.domain;

import com.example.practice.repository.UserJpaDto;
import com.example.practice.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserJpaRepository repository;
    private final UserConverterService converter;
    @Autowired
    public UserService(UserJpaRepository repository, UserConverterService converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<User> getAllUsers() {
        final List<UserJpaDto> usersJpaDtos = repository.findAll();
        final List<User> users = new java.util.ArrayList<>(List.of());
        usersJpaDtos.forEach(userJpaDto -> users.add(converter.convertJpaDtoToUser(userJpaDto)));
        return users;
    }

    public List<UserResponseDto> getUsers() {
        final List<User> users = getAllUsers();
        final List<UserResponseDto> response  = new java.util.ArrayList<>(List.of());
        users.forEach(user -> response.add(converter.convertUserToResponseUser(user)));
        return response;
    }
}
