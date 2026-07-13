package com.example.springtests;

import com.example.springtests.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "3, 4, 7", "10, 5, 15"})
    void addShouldReturnExpectedSum(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
