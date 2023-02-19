package com.carson.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.carson.login.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
Optional<User> findByEmail(String email);
    
}
