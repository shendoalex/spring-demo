package org.example.springdemo.exception;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(ExceptionMessage message) {
        super(message.getTextMessage());
    }

}
