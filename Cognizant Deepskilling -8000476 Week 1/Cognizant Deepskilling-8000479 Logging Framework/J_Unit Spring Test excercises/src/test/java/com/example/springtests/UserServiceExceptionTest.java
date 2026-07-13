package com.example.springtests;

import com.example.springtests.repository.UserRepository;
import com.example.springtests.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getRequiredUserByIdShouldThrowWhenMissing() {
        when(userRepository.findById(42L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getRequiredUserById(42L));
    }
}
