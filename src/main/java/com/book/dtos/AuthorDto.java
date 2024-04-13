package com.book.dtos;

import com.book.entities.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private String id;
    private String name;
    private String image;
//    private List<Book> books;
}
