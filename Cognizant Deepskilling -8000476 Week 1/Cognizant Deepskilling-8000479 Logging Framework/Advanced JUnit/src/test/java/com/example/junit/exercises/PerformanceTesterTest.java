package com.example.junit.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class PerformanceTesterTest {
    private final PerformanceTester tester = new PerformanceTester();

    @Test
    void shouldCompleteWithinTimeout() {
        assertTimeoutPreemptively(java.time.Duration.ofMillis(500), () -> tester.performTask(100));
    }
}
