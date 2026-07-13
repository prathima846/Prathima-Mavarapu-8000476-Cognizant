package com.example.junit.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> thrower.throwException("boom")
        );
        org.junit.jupiter.api.Assertions.assertEquals("boom", exception.getMessage());
    }
}
