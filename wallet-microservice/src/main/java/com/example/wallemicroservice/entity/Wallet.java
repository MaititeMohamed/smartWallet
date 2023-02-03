package com.example.wallemicroservice.entity;

import jakarta.persistence.*;
import org.aspectj.bridge.Message;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private Float balance;
    @Column(nullable = false)
    private  String Owner ;
    @Column(nullable = false)
    private  String referenceWallet;

    public Wallet() {
    }

    public Wallet(Float balance, String owner, String referenceWallet) {
        this.balance = balance;
        Owner = owner;
        this.referenceWallet = referenceWallet;
    }

    public Wallet(Long id, Float balance, String owner, String referenceWallet) {
        this.id = id;
        this.balance = balance;
        Owner = owner;
        this.referenceWallet = referenceWallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getReferenceWallet() {
        return referenceWallet;
    }

    public void setReferenceWallet(String referenceWallet) {
        this.referenceWallet = referenceWallet;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", Owner='" + Owner + '\'' +
                ", referenceWallet='" + referenceWallet + '\'' +
                '}';
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
