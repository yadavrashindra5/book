package com.book.repositories;

import com.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book,String> {

    @Query(value = "SELECT name,id FROM book",nativeQuery = true)
    List<Map<String,String>> findBooksWithId();
}
