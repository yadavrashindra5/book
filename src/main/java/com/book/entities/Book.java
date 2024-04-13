package com.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content100;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content500;
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content1000;
    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    private String image;
    private boolean evergreen;
    private boolean latest;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private Author author_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
