package com.example.transactionmicroservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Builder
@Setter
@Getter
public class TransactionDto {
    private String  id;
    private String transactionType;
    private String referenceWallet;
    private LocalDate transactionDate;
    private Float balance;
    private Float Amount; // withdraw or deposit
    private String description;
    private  Float finalBalance;
}
