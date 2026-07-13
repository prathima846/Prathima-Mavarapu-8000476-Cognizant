package com.example.junit.exercises;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {
    @Order(2)
    @Test
    void secondTest() {
        assertTrue(true);
    }

    @Order(1)
    @Test
    void firstTest() {
        assertTrue(true);
    }
}
