package com.example.springtests;

import com.example.springtests.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void addShouldReturnSumOfTwoNumbers() {
        int result = calculatorService.add(2, 3);
        assertEquals(5, result);
    }
}
