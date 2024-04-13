package com.book.dtos;

import com.book.entities.Book;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private String id;
    private String title;
    private String image;
    private List<Book> books=new ArrayList<>();
}
