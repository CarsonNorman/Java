package com.carson.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.bookclub.models.Book;
import com.carson.bookclub.repositories.BookRepository;

@Service
public class BookService {
    @Autowired BookRepository bookRepo;

    public List<Book> allBooks(){
        return bookRepo.findAll();
    }

    public Book addBook(Book newBook){
        return bookRepo.save(newBook);
    }

    public Book getBook(Long id){
        Optional<Book>book = bookRepo.findById(id);
        return book.orElse(null);
    }
}
