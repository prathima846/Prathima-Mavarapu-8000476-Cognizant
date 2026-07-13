package com.example.springtests;

import com.example.springtests.model.User;
import com.example.springtests.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByNameShouldReturnMatchingUsers() {
        userRepository.save(new User("Eve"));
        userRepository.save(new User("Eve"));
        userRepository.save(new User("Alice"));

        List<User> users = userRepository.findByName("Eve");

        assertEquals(2, users.size());
    }
}
