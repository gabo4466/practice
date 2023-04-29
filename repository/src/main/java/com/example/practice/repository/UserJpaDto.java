package com.example.practice.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserJpaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserJpaDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserJpaDto() {
        id = 0L;
        name = "";
    }
}
