package com.book.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"books"})
public class Category {
    @Id
    private String id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String image;
    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();
}
