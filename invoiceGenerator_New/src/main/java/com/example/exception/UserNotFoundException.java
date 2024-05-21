package com.example.exception;

import com.example.invoice.Users;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Users userId) {
        super();
    }
}


