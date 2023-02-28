package com.carson.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carson.bookclub.models.LoginUser;
import com.carson.bookclub.models.User;
import com.carson.bookclub.services.UserService;


@Controller
public class LoginController {
    
    // Add once service is implemented: 
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login/index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
                User user = userServ.register(newUser, result);
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login/index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        System.out.println(user);
        System.out.println("=============================================================");

        if(user != null){
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
        }
        
    
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login/index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
    
        return "redirect:/books";
    }

   
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("id");
        session.removeAttribute("username");
        return "redirect:/";
    }
    
    
  
    
}
