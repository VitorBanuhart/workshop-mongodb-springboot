package com.projeto_udemy.projeto_udemy.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
