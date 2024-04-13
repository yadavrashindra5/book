package com.book.dtos;

import com.book.entities.Author;
import com.book.entities.Category;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String id;
    private String name;
    private String content100;
    private String content500;
    private String content1000;
    private String slug;
    private String image;
    private boolean evergreen;
    private boolean latest;
    private Author author_id;
}
