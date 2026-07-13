package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Alice";
        int orderId = 101;

        logger.info("User {} placed order {}", userName, orderId);
        logger.debug("Debugging order {} for {}", orderId, userName);
    }
}
