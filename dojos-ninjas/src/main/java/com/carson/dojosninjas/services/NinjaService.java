package com.carson.dojosninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.dojosninjas.models.Ninja;
import com.carson.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    @Autowired NinjaRepository ninjaRepository;

    public void create(Ninja ninja){
        ninjaRepository.save(ninja);
    }

}
