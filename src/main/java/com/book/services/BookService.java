package com.book.services;

import com.book.dtos.BookDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookService {
    BookDto create(BookDto bookDto);
    BookDto get(String book_id);
    BookDto update(String book_id,BookDto bookDto);
    void delete(String book_id);

    BookDto assignAuthorToBook(String author_id,String book_id);
    BookDto assignCategoryToBook(String author_id,String book_id);
    List<BookDto>getAll();
    List<Map<String,String>> getBooksWithNameAndId();
}
