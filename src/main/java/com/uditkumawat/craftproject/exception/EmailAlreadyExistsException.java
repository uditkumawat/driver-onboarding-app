package com.uditkumawat.craftproject.exception;

/**
 * Wrapper exception if email already exists for that driver
 */
public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
