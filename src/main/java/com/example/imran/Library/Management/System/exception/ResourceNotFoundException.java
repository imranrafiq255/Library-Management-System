package com.example.imran.Library.Management.System.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
