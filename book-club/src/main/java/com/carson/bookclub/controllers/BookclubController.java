package com.carson.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.carson.bookclub.models.Book;
import com.carson.bookclub.services.BookService;

@Controller
public class BookclubController {

    @Autowired BookService bookServ;
//Read
    @GetMapping("/books")
    public String welcome(HttpSession session, Model model){
        if(session.getAttribute("userId") != null){
        List<Book>books = bookServ.allBooks();
        model.addAttribute("books", books);
        return "bookclub/home.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/books/show/{id}")
    public String showOne(@PathVariable("id")Long id, Model model){
        Book book = bookServ.getBook(id);
        model.addAttribute("book", book);
        return "bookclub/show.jsp";
    }

//Create
    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("edit", false);
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

//Update
    @GetMapping("/books/edit/{id}")
    public String editBook(Model model, @PathVariable("id")Long id, 
    @ModelAttribute("newBook")Book newBook) {
        Book book = bookServ.getBook(id);
        model.addAttribute("edit", true);
        model.addAttribute("book", book);
        return "bookclub/new.jsp";
    }
    
    @PutMapping("/books/edit")
    public String editBook(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result,
     HttpSession session, Model model){
        System.out.println(newBook.getTitle());
        System.out.println(newBook.getAuthor());
        System.out.println(newBook.getThoughts());
        System.out.println(newBook.getUser());
        System.out.println(newBook.getId());

        if(result.hasErrors()){
            return "bookclub/new.jsp";
        }

        bookServ.editBook(newBook);
        return "redirect:/books";
    }

    
//Delete
    @DeleteMapping("/books/delete/{id}")
    public String destroy(@PathVariable("id")Long id){
        Book book = bookServ.getBook(id);
        bookServ.deleteBook(book);
        return "redirect:/books";
    }

}
