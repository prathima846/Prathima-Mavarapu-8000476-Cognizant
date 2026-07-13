package com.example.junit.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EvenCheckerTest {
    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void shouldReturnTrueForEvenNumbers(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    void shouldReturnFalseForOddNumbers(int number) {
        assertFalse(checker.isEven(number));
    }

    @Test
    void shouldHandleZeroAsEven() {
        assertTrue(checker.isEven(0));
    }
}
