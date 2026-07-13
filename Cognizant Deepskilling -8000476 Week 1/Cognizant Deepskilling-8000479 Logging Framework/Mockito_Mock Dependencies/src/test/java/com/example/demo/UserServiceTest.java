package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserWhenRepositoryFindsIt() {
        User user = new User();
        user.setId(2L);
        user.setName("Bob");

        when(userRepository.findById(2L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(2L);

        assertEquals(user, result);
        verify(userRepository).findById(2L);
    }
}
