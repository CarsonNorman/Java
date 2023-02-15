package com.carson.travels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.travels.models.Expense;
import com.carson.travels.repositories.TravelRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    @Autowired TravelRepository travelRepository;

    public void createExpense(Expense expense){
        travelRepository.save(expense);
    }

    public List<Expense> allExpenses(){
        return travelRepository.findAll();
    }


    public Expense getOneExpense(Long id){
        Optional<Expense> optionalExpense = travelRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    public void editExpense(Expense expense){
        travelRepository.save(expense);
    }

    public void deleteExpense(Expense expense){
        travelRepository.delete(expense);
    }
    
}
