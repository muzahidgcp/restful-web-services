package com.smh.rest.webservices.restfulwebservices.self;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SelfUserNotFoundException extends RuntimeException {
    /**
     *
     * @param message
     */
    public SelfUserNotFoundException(String message) {
        super(message);
    }
}
