package com.book.services.implementation;

import com.book.dtos.AuthorDto;
import com.book.entities.Author;
import com.book.entities.Book;
import com.book.repositories.AuthorRepository;
import com.book.response.AuthorList;
import com.book.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper mapper;

    private Logger logger= LoggerFactory.getLogger(AuthorServiceImpl.class);
    @Override
    public AuthorList create(AuthorDto authorDto) {
        String id = UUID.randomUUID().toString();
        authorDto.setId(id);
        Author author=mapper.map(authorDto,Author.class);
        Author savedAuthor = authorRepository.save(author);
        return mapper.map(savedAuthor,AuthorList.class);
    }

    @Override
    public AuthorDto get(String author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Provided id not found"));
        logger.info("author{}",author);

        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setImage(author.getImage());
        List<Book> bookList = new ArrayList<>();
        for(Book a:author.getBooks()){
            bookList.add(a);

        }
//        authorDto.setBooks(bookList);

        return authorDto;

//        return mapper.map(author,AuthorDto.class);
    }

    @Override
    public void delete(String author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Provided id not found"));
        authorRepository.delete(author);
    }

    @Override
    public AuthorDto update(AuthorDto authorDto, String author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Provided id not found"));
        author.setName(authorDto.getName());
        authorDto.setImage(authorDto.getImage());
        Author savedAuthor = authorRepository.save(author);
        return mapper.map(savedAuthor,AuthorDto.class);
    }

    @Override
    public List<AuthorList> getAllAuthor() {
        List<Author> allAuthor= authorRepository.findAll();
        List<AuthorList> collect = allAuthor.stream().map((author -> mapper.map(author, AuthorList.class))).toList();
        return collect;
    }
}
