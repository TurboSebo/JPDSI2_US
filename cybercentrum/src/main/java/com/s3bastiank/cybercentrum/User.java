package com.s3bastiank.cybercentrum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id //To adnotacja z JPA (Java Persistence API), która mówi Springowi, że ta klasa jest odwzorowaniem tabeli w bazie danych.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Oznacza, że wartość id będzie generowana automatycznie przez bazę danych
    private Long id;
    private String username;
    private String email;
    private String password;

    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;}

    public String getUsername() { return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() { return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
