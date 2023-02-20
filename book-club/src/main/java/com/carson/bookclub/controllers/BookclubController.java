package com.carson.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.carson.bookclub.models.Book;
import com.carson.bookclub.services.BookService;

@Controller
public class BookclubController {

    @Autowired BookService bookServ;

    @GetMapping("/books")
    public String welcome(HttpSession session, Model model){
        if(session.getAttribute("id") != null){
        List<Book>books = bookServ.allBooks();
        model.addAttribute("books", books);
        return "bookclub/home.jsp";
        }
        return "redirect:/";
    }
    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "bookclub/new.jsp";
    }
    @PostMapping("/book")
    public String addBook(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result, HttpSession session){
        
        if(result.hasErrors()){
            return "bookclub/new.jsp";
        }

        bookServ.addBook(newBook);
        return "redirect:/books";
    }

    @GetMapping("/books/show/{id}")
    public String showOne(@PathVariable("id")Long id, Model model){
        Book book = bookServ.getBook(id);
        model.addAttribute("book", book);
        return "bookclub/show.jsp";
    }

}
