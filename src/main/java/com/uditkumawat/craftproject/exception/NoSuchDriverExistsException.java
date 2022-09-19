package com.uditkumawat.craftproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchDriverExistsException extends Exception{

    public NoSuchDriverExistsException(String message){
        super(message);
    }
}


