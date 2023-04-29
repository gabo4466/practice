package com.example.practice.domain;

import com.example.practice.repository.UserJpaDto;
import org.springframework.stereotype.Service;

@Service
public class UserConverterService {
    public User convertJpaDtoToUser(UserJpaDto userJpaDto) {
        return new User(userJpaDto.getId(), userJpaDto.getName());
    }

    public UserResponseDto convertUserToResponseUser(User user) {
        return new UserResponseDto(user.getId(), user.getName());
    }
}
