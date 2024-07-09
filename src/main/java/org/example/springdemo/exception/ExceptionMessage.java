package org.example.springdemo.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    BOOK_NOT_EXIST("bookdoes not exist");

    private final String textMessage;

    ExceptionMessage(String textMessage) {
        this.textMessage = textMessage;
    }

}
