package com.example.walletmicrosevice.entity;


import com.example.walletmicrosevice.util.Message;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Column(nullable = false)
    private  float balance;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    private String referenceWallet;
    @Transient
    private Message message;


}
