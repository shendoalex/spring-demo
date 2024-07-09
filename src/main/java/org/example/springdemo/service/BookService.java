package org.example.springdemo.service;

import org.example.springdemo.model.BookDto;

import java.util.List;

public interface BookService {

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks();

    void addBook(BookDto bookEntity);

    List<BookDto> findByAuthor(String authorName);

}
