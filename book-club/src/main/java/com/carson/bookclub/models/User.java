package com.carson.bookclub.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Username is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String username;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    private List<Book> books;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="borrow",
        joinColumns = @JoinColumn(name="users.id"),
        inverseJoinColumns = @JoinColumn(name="books.id")
    )
    private List<Book> bBooks;
  

    public User() {
    }

    public User(Long id, String username, String email, String password, String confirm, List<Book> books, List<Book> bBooks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.books = books;
        this.bBooks = bBooks;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBBooks() {
        return this.bBooks;
    }

    public void setBBooks(List<Book> bBooks) {
        this.bBooks = bBooks;
    }
    
   
}

    
