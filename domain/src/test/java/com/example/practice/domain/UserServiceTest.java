package com.example.practice.domain;

import com.example.practice.repository.UserJpaDto;
import com.example.practice.repository.UserJpaRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private final UserJpaRepository repository = mock(UserJpaRepository.class);

    private final UserConverterService converter = new UserConverterService();
    private final UserService service = new UserService(repository, converter);



    @Test
    public void shouldGetAllUsers() {
        final List<UserJpaDto> usersJpaDto = List.of(
          new UserJpaDto(1L, "name")
        );
        final List<User> expected = List.of(
                new User(usersJpaDto.get(0).getId(), usersJpaDto.get(0).getName())
        );

        when(repository.findAll()).thenReturn(usersJpaDto);

        final List<User> result = service.getAllUsers();

        assertEquals(expected, result);
    }

    @Test
    public void shouldGetUsers() {
        final List<UserJpaDto> usersJpaDto = List.of(
                new UserJpaDto(1L, "name")
        );
        final List<UserResponseDto> expected = List.of(
                new UserResponseDto(usersJpaDto.get(0).getId(), usersJpaDto.get(0).getName())
        );

        when(repository.findAll()).thenReturn(usersJpaDto);

        final List<UserResponseDto> result = service.getUsers();

        assertEquals(expected, result);

    }
}
