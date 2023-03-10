package com.example.transactionmicroservice.controller;


import com.example.transactionmicroservice.dto.TransactionDto;
import com.example.transactionmicroservice.entity.Transaction;
import com.example.transactionmicroservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;



    @PostMapping(path = "/createTransaction")
    public  Transaction createTransaction(@RequestBody TransactionDto transactionDto){
         return  transactionService.createTransaction(transactionDto);
    }
}
