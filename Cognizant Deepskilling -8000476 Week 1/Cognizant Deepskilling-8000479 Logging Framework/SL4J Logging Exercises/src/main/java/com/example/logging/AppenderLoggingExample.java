package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.info("This message will be sent to both console and file appenders.");
        logger.warn("This warning will also be written to the configured appenders.");
    }
}
