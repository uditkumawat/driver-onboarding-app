package com.uditkumawat.craftproject.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
