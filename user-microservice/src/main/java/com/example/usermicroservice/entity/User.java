package com.example.usermicroservice.entity;

import com.example.usermicroservice.util.Message;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String firstName;
    @Column(nullable = false)
    private  String  lastName;
    @Column(unique = true,nullable = false)
    private  String  email;
    @Column(nullable = false)
    private  String  password;
    @Column(nullable = false)
    private  String cin ;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String cin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cin = cin;
    }

    public User(Long id, String firstName, String lastName, String email, String password, String cin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cin = cin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Transient
    private Message message;

    public Message getMessage ( ) {
        return message;
    }

    public void setMessage ( Message message ) {
        this.message = message;
    }
}
