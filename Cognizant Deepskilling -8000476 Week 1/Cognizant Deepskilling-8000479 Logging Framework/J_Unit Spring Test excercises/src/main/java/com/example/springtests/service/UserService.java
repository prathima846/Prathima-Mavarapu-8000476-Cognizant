package com.example.springtests.service;

import com.example.springtests.model.User;
import com.example.springtests.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public @Nullable User getUserById(@NonNull Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public @NonNull User saveUser(@NonNull User user) {
        return userRepository.save(user);
    }

    public @NonNull User getRequiredUserById(@NonNull Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        assert user != null;
        return java.util.Objects.requireNonNull(user, "User must not be null");
    }
}
