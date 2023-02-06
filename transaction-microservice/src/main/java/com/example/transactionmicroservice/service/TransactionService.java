package com.example.transactionmicroservice.service;

import com.example.transactionmicroservice.entity.Transaction;
import com.example.transactionmicroservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;


    public String convertCase(String TransactionType) {
        if (TransactionType.equals(TransactionType.toUpperCase())) {
            return TransactionType.toLowerCase();
        }
          return  TransactionType;
    }

    public float operation(Transaction transaction){
        String typeOfOperation = convertCase(transaction.getTransactionType());
        float balance = transaction.getBalance();
        float toBalance = transaction.getToBalance();

        if ("withdraw".equals(typeOfOperation)) {
            balance = balance - toBalance;
            return balance;
        }

        if ("deposit".equals(typeOfOperation)) {
             balance = balance + toBalance;
            return balance;
        }

        return balance;
    }


    public Transaction createTransaction(Transaction transaction){
        transaction.setFinalBalance(operation(transaction));
     return    transactionRepository.save(transaction);
    }

}
