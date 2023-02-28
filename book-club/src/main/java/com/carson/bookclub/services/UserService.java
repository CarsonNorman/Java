package com.carson.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.carson.bookclub.models.LoginUser;
import com.carson.bookclub.models.User;
import com.carson.bookclub.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> user = userRepo.findByEmail(newUser.getEmail());
        if(user.isPresent()){
            result.rejectValue("email", "Email", "Email already registered.");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm", "Confirm", "Passwords must match");
        }
        if(result.hasErrors()){
            return null;
        }
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLogin, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());

        if(potentialUser.isPresent()){
            if(!BCrypt.checkpw(newLogin.getPassword(), potentialUser.orElseThrow().getPassword())) {
                result.rejectValue("password", "Matches", "Invalid Password!");
            } 
        }else{
            result.rejectValue("email", "Email", "Invalid Email");
        }
        if(result.hasErrors()){
            return null;
          }
    return potentialUser.orElse(null);
    }
    public User getUser(Long id){
        Optional<User>book = userRepo.findById(id);
        return book.orElse(null);
    }
}
