package com.auth.config.exception.handler;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
