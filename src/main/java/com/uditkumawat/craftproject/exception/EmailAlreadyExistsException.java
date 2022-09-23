package com.uditkumawat.craftproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Wrapper exception if email already exists for that driver
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
