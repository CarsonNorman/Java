package com.carson.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.bookclub.models.Book;
import com.carson.bookclub.models.User;
import com.carson.bookclub.repositories.BookRepository;
import com.carson.bookclub.repositories.UserRepository;

@Service
public class BookService {
    @Autowired BookRepository bookRepo;
    @Autowired UserRepository userRepo;

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
    public void deleteBook(Book book){
        bookRepo.delete(book);
    }
    public Book editBook(Book book){
        return bookRepo.save(book);
    }

    public Book addBorrowed(Long bookId, Long userId){
        Optional<Book> currBook = bookRepo.findById(bookId);

        Optional<User> currUser = userRepo.findById(userId);

        if(currBook.isPresent() && currUser.isPresent()){
            Book book = currBook.get();
            User user = currUser.get();
            book.getBUsers().add(user);
            return bookRepo.save(book);
        }
        return null;
    }
}
