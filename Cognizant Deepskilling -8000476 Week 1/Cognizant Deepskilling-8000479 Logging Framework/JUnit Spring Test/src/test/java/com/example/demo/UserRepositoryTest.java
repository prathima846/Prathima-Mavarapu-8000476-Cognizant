package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByNameReturnsUsers() {
        userRepository.save(new User(1L, "Alice"));
        userRepository.save(new User(2L, "Alice"));
        userRepository.save(new User(3L, "Bob"));

        List<User> users = userRepository.findByName("Alice");

        assertThat(users).hasSize(2);
        assertThat(users).extracting(User::getName).containsOnly("Alice");
    }
}
