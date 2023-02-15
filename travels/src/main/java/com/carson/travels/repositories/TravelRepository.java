package com.carson.travels.repositories;
import org.springframework.data.repository.CrudRepository;

import com.carson.travels.models.Expense;

import java.util.List;

public interface TravelRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();
}
