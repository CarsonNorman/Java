package com.carson.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.dojosninjas.models.Dojo;
import com.carson.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
    @Autowired DojoRepository dojoRepository;

    public void create(Dojo dojo){
        dojoRepository.save(dojo);
    }
    public List<Dojo> allDojos(){
        return dojoRepository.findAll();
    }


    public Dojo oneDojo(Long id){
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }

    // public void editExpense(Dojo dojo){
    //     dojoRepository.save(dojo);
    // }

    // public void deleteExpense(Dojo dojo){
    //     dojoRepository.delete(dojo);
    // }
}
