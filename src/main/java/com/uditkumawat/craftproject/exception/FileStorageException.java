package com.uditkumawat.craftproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 It’s thrown when an unexpected situation occurs while storing a file in the file system
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStorageException extends Exception{

    public FileStorageException(String message,Throwable cause){
        super(message,cause);
    }

    public FileStorageException(String message){
        super(message);
    }
}
