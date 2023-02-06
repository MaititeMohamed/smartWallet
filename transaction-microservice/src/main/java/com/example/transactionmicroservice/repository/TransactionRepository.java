package com.example.transactionmicroservice.repository;

import com.example.transactionmicroservice.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,Long> {
}
