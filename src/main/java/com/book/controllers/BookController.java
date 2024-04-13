package com.book.controllers;

import com.book.dtos.BookDto;
import com.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto){
        BookDto savedBook= bookService.create(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<BookDto> get(@PathVariable(value = "book_id") String book_id){
        BookDto bookDto = bookService.get(book_id);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

    @PutMapping("/{book_id}")
    public ResponseEntity<BookDto> update(@PathVariable(value = "book_id") String book_id,@RequestBody BookDto bookDto){
        BookDto updateBook = bookService.update(book_id, bookDto);
        return new ResponseEntity<>(updateBook,HttpStatus.OK);
    }

    @DeleteMapping("/{book_id}")
    public void delete(String book_id){
        bookService.delete(book_id);
    }

    @PutMapping("/{author_id}/{book_id}")
    public ResponseEntity<BookDto>assignAuthorToBook(@PathVariable(value = "author_id") String author_id, @PathVariable(value = "book_id") String book_id){
        BookDto bookDto = bookService.assignAuthorToBook(author_id, book_id);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

    @PutMapping("/category/{category_id}/{book_id}")
    public ResponseEntity<BookDto>assignCategoryToBook(@PathVariable(value = "category_id") String category_id, @PathVariable(value = "book_id") String book_id){
        BookDto bookDto = bookService.assignCategoryToBook(category_id, book_id);
        return new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>>getAll(){
        List<BookDto> booksList = bookService.getAll();
        return new ResponseEntity<>(booksList,HttpStatus.OK);
    }

    @GetMapping("/name/id")
    public ResponseEntity<List<Map<String,String>>> getBooksWithId(){
        List<Map<String, String>> booksWithNameAndId = bookService.getBooksWithNameAndId();
        return new ResponseEntity<>(booksWithNameAndId,HttpStatus.OK);
    }
}
