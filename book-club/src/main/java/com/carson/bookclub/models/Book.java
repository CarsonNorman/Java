package com.carson.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String thoughts;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="borrow",
        joinColumns = @JoinColumn(name="books.id"),
        inverseJoinColumns = @JoinColumn(name="users.id")
    )
    private List<User> bUsers;




    public Book() {
    }

    public Book(Long id, String title, String author, String thoughts, Date created_at, Date updated_at, User user, List<User> bUsers) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.thoughts = thoughts;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
        this.bUsers = bUsers;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThoughts() {
        return this.thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getBUsers() {
        return this.bUsers;
    }

    public void setBUsers(List<User> bUsers) {
        this.bUsers = bUsers;
    }
    


    
}
