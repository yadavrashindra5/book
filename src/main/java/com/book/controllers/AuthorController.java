package com.book.controllers;

import com.book.dtos.AuthorDto;
import com.book.response.AuthorList;
import com.book.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @PostMapping
    public ResponseEntity<AuthorList> create(@RequestBody  AuthorDto authorDto){
        AuthorList createdAuthor= authorService.create(authorDto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/{author_id}")
    public ResponseEntity<AuthorDto>get(@PathVariable(value = "author_id") String author_id){
        AuthorDto getAuthor = authorService.get(author_id);
        return new ResponseEntity<>(getAuthor,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorList>>getAllAuthor(){
        List<AuthorList> list=authorService.getAllAuthor();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
