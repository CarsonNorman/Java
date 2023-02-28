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
import org.springframework.web.bind.annotation.RequestMapping;

import com.carson.bookclub.models.Book;
import com.carson.bookclub.models.User;
import com.carson.bookclub.services.BookService;
import com.carson.bookclub.services.UserService;

@Controller
public class BookclubController {

    @Autowired BookService bookServ;
    @Autowired UserService userServ;
//Read
    @GetMapping("/books")
    public String welcome(HttpSession session, Model model){
        if(session.getAttribute("userId") != null){
        List<Book>books = bookServ.allBooks();
        User user = userServ.getUser(((Long)session.getAttribute("userId")));
        System.out.println(user.getBBooks().get(0).getTitle());
        model.addAttribute("books", books);
        model.addAttribute("borrowed", user.getBBooks());

        return "bookclub/home.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/books/show/{id}")
    public String showOne(@PathVariable("id")Long id, Model model, HttpSession session){
        if(session.getAttribute("userId") != null){
        Book book = bookServ.getBook(id);
        model.addAttribute("book", book);
        return "bookclub/show.jsp";
        }
        return "redirect:/";
    }

//Create
    @GetMapping("/books/new")
    public String newBook(Model model, HttpSession session) {
        if(session.getAttribute("userId") != null){
        model.addAttribute("newBook", new Book());
        model.addAttribute("edit", false);
        return "bookclub/new.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/book")
    public String addBook(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result, HttpSession session){
        if(session.getAttribute("userId") != null){
        
        if(result.hasErrors()){
            return "bookclub/new.jsp";
        }

        bookServ.addBook(newBook);
        return "redirect:/books";
    }
    return "redirect:/";
    }

//Update
    @GetMapping("/books/edit/{id}")
    public String editBook(Model model, @PathVariable("id")Long id, 
    @ModelAttribute("newBook")Book newBook, HttpSession session) {
        if(session.getAttribute("userId") != null){

        Book book = bookServ.getBook(id);
        model.addAttribute("edit", true);
        model.addAttribute("book", book);
        return "bookclub/new.jsp";
        }
        return "redirect:/";
    }
    
    @PutMapping("/books/edit")
    public String editBook(@Valid @ModelAttribute("newBook")Book newBook,BindingResult result,
     HttpSession session, Model model){
        if(session.getAttribute("userId") != null){


        if(result.hasErrors()){
            return "bookclub/new.jsp";
        }

        bookServ.editBook(newBook);
        return "redirect:/books";
    }
    return "redirect:/";
    }

    
//Delete
    @DeleteMapping("/books/delete/{id}")
    public String destroy(@PathVariable("id")Long id, HttpSession session){
        if(session.getAttribute("userId") != null){

        Book book = bookServ.getBook(id);
        bookServ.deleteBook(book);
        return "redirect:/books";
    }
    return "redirect:/";
}
//Borrow routing
    @RequestMapping("/books/borrow/{id}")
    public String borrow(@PathVariable("id")Long id, HttpSession session){
        System.out.println(session.getAttribute("userId"));
        Long userId = ((Long)session.getAttribute("userId"));
        bookServ.addBorrowed(id, userId);
        System.out.println(userId);


        return "redirect:/books";
    }
}
