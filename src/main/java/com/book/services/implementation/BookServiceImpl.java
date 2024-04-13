package com.book.services.implementation;

import com.book.dtos.BookDto;
import com.book.entities.Author;
import com.book.entities.Book;
import com.book.entities.Category;
import com.book.repositories.AuthorRepository;
import com.book.repositories.BookRepository;
import com.book.repositories.CategoryRepository;
import com.book.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public BookDto create(BookDto bookDto) {
        bookDto.setId(UUID.randomUUID().toString());
        Book mappedBook= mapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(mappedBook);
        return mapper.map(savedBook,BookDto.class);
    }

    @Override
    public BookDto get(String book_id) {
        Book book= bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Provided id not found"));
        return mapper.map(book,BookDto.class);
    }

    @Override
    public BookDto update(String book_id, BookDto bookDto) {
        Book book= bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Provided id not found"));
        book.setContent100(bookDto.getContent100());
        book.setContent500(bookDto.getContent500());
        book.setContent1000(bookDto.getContent1000());
        book.setEvergreen(bookDto.isEvergreen());
        book.setLatest(bookDto.isLatest());
        book.setSlug(bookDto.getSlug());
        book.setImage(bookDto.getImage());

        Book savedBook = bookRepository.save(book);
        return mapper.map(savedBook, BookDto.class);
    }

    @Override
    public void delete(String book_id) {
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("provided id not found"));
        bookRepository.delete(book);
    }

    @Override
    public BookDto assignAuthorToBook(String author_id, String book_id) {
//        //find author
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new RuntimeException("Provided author id not found"));
        //find book
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Provided book not found"));
        book.setAuthor_id(author);

        author.getBooks().add(book);
        authorRepository.save(author);

        return mapper.map(book,BookDto.class);
    }

    @Override
    public BookDto assignCategoryToBook(String category_id, String book_id) {
//        //find author
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new RuntimeException("Provided author id not found"));
        //find book
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Provided book not found"));
        book.setCategory(category);

        category.getBooks().add(book);
        categoryRepository.save(category);

        return mapper.map(book,BookDto.class);
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> books= bookRepository.findAll();
        List<BookDto> bookDtos= books.stream().map(book -> mapper.map(book, BookDto.class)).collect(Collectors.toList());
        return bookDtos;
    }

    @Override
    public List<Map<String,String>> getBooksWithNameAndId() {
        List<Map<String,String>> booksWithId = bookRepository.findBooksWithId();
        return booksWithId;
    }

}
