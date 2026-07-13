package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParameterizedCalculatorTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 7, 12",
        "-3, 3, 0"
    })
    void addMultipleInputs(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
