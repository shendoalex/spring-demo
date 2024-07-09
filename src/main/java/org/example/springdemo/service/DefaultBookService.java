package org.example.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.springdemo.dao.entity.BookEntity;
import org.example.springdemo.mapper.BookDtoToBookEntityMapper;
import org.example.springdemo.model.BookDto;
import org.example.springdemo.dao.repository.BookRepository;
import org.example.springdemo.exception.EntityNotFoundException;
import org.example.springdemo.exception.ExceptionMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    private final BookDtoToBookEntityMapper mapper;

    @Override
    public BookDto getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessage.BOOK_NOT_EXIST));

//        return new BookDto(bookEntity.getId(),
//                bookEntity.getAuthor(),
//                bookEntity.getTitle(),
//                bookEntity.getPrice());

        return mapper.bookEntityToBookDto(bookEntity);

    }

    public List<BookDto> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();

        ArrayList<BookDto> books = new ArrayList<>();

        for (BookEntity bookEntity : iterable) {

//            books.add(new BookDto(bookEntity.getId(),
//                    bookEntity.getAuthor(),
//                    bookEntity.getTitle(),
//                    bookEntity.getPrice()));

            books.add(mapper.bookEntityToBookDto(bookEntity));

        }

        return books;

    }

    public void addBook(BookDto bookDto) {

//        BookEntity bookEntity = new BookEntity(null,
//                bookDto.getAuthor(),
//                bookDto.getTitle(),
//                bookDto.getPrice());

        BookEntity bookEntity = mapper.bookDtoToBookEntityMapper(bookDto);

        bookRepository.save(bookEntity);

    }

    @Override
    public List<BookDto> findByAuthor(String author) {

        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);

        ArrayList<BookDto> books = new ArrayList<>();

        for (BookEntity bookEntity : iterable) {
            books.add(mapper.bookEntityToBookDto(bookEntity));
        }

        return books;
    }

}
