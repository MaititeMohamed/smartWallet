package com.example.transactionmicroservice.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@Document(collection="transaction")
public class Transaction {
    @Id
    private String  id;
    private String transactionType;
    private String referenceWallet;
    private LocalDate transactionDate;
    private Float balance;
    private Float toBalance; //withdraw or deposit
    private String description;
    private  Float finalBalance;


}
