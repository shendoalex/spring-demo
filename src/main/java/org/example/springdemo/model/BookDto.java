package org.example.springdemo.model;

import lombok.Value;

@Value
public class BookDto {

    Long id;
    String author;
    String title;
    Double price;

}
