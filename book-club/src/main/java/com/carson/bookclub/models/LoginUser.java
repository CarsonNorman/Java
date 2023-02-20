package com.carson.bookclub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
    
    @NotEmpty(message = "Email Required")
    @Email(message="Please enter a valid email")
    private String email;

    @NotEmpty(message = "Password Required")
    @Size(min=8,max=32, message = "Please enter a password between 8-32 chars")
    private String password;


    public LoginUser() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
