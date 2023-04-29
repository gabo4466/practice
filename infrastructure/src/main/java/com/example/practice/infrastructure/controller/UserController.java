package com.example.practice.infrastructure.controller;


import com.example.practice.domain.UserResponseDto;
import com.example.practice.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        final List<UserResponseDto> users = service.getUsers();
        return ResponseEntity.ok().body(List.of());
    }

}
