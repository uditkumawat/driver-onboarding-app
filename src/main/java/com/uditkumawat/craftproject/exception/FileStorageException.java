package com.uditkumawat.craftproject.exception;

//It’s thrown when an unexpected situation occurs while storing a file in the file system
public class FileStorageException extends RuntimeException{

    public FileStorageException(String message,Throwable cause){
        super(message,cause);
    }

    public FileStorageException(String message){
        super(message);
    }
}
