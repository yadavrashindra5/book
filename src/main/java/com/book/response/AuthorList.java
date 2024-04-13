package com.book.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorList {
    private String id;
    private String name;
    private String image;
}
