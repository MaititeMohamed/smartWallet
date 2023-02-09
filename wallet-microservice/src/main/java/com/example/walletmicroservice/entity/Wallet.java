package com.example.walletmicroservice.entity;


import com.example.walletmicroservice.util.Message;
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
    @Column(nullable = false)
    private  float balance;
    @Column(nullable = false)
    private String ownerCin;
    @Column(nullable = false)
    private String referenceWallet;
    @Transient
    private Message message;


}
