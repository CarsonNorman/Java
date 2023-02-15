package com.carson.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carson.travels.models.Expense;
import com.carson.travels.services.TravelService;

@Controller
public class MainController {
    @Autowired TravelService travelService;

    @RequestMapping("/")
    public String index(Model model){
        List<Expense> expenses = travelService.allExpenses();
        System.out.println(expenses);
        model.addAttribute("expenses", expenses);
        return "index.jsp";

    }

    @RequestMapping("/new")
    public String newExpense(@ModelAttribute("expense")Expense expense){
        return "new.jsp";
    }

    //Create
    @PostMapping("/new/expense")
    public String createExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result){
        if(result.hasErrors()){
            return "new.jsp";
        } else{
            travelService.createExpense(expense);
            System.out.println("----------------- Created new expense --------------------");
            return "redirect:/";
        }
    }
    @GetMapping("/expense/view/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        Expense expense = travelService.getOneExpense(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }
    
    //update

    @GetMapping("/expense/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model){
        Expense expense = travelService.getOneExpense(id);
        model.addAttribute("expense", expense);
        model.addAttribute("edit", true);
        return "new.jsp";
    }
    @PutMapping("/expense/{id}")
    public String editExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result, @PathVariable("id")Long id){
        if(result.hasErrors()){
            return "new.jsp";
        }else{
            travelService.editExpense(expense);
            return "redirect:/";
        }
    }

    //delete
    @DeleteMapping("/expense/{id}")
    public String destroy(@PathVariable("id")Long id){
        Expense expense = travelService.getOneExpense(id);
        travelService.deleteExpense(expense);
        return "redirect:/";
    }
   
}
