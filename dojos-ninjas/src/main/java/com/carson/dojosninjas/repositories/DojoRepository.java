package com.carson.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.carson.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
