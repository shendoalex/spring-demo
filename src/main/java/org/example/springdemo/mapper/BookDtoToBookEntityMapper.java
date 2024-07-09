package org.example.springdemo.mapper;

import org.example.springdemo.dao.entity.BookEntity;
import org.example.springdemo.model.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDtoToBookEntityMapper {

    BookEntity bookDtoToBookEntityMapper(BookDto bookDto);

    BookDto bookEntityToBookDto(BookEntity bookEntity);
}
