package com.book.services;

import com.book.dtos.AuthorDto;
import com.book.response.AuthorList;

import java.util.List;

public interface AuthorService {
    AuthorList create(AuthorDto authorDto);
    AuthorDto get(String author_id);
    void delete(String author_id);
    AuthorDto update(AuthorDto authorDto,String author_id);
    List<AuthorList> getAllAuthor();
}
