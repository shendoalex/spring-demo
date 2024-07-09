package org.example.springdemo.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.springdemo.mapper.BookDtoToBookRequestMapper;
import org.example.springdemo.model.BookDto;
import org.example.springdemo.model.BookRequest;
import org.example.springdemo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookDtoToBookRequestMapper bookDtoToBookRequestMapper;

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null) {
            return bookService.findByAuthor(author);
        }
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(bookDtoToBookRequestMapper.AddBookRequestToBookDto(request));
    }

}
