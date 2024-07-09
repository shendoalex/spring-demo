package org.example.springdemo.mapper;

import org.example.springdemo.model.BookDto;
import org.example.springdemo.model.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDtoToBookRequestMapper {

    BookDto AddBookRequestToBookDto(BookRequest bookRequest);

    BookDto EditBookRequestToBookDto(Long id, BookRequest bookRequest);

}
