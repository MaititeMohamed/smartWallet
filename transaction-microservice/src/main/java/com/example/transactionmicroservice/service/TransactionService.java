package com.example.transactionmicroservice.service;
import com.example.transactionmicroservice.entity.Transaction;
import com.example.transactionmicroservice.repository.TransactionRepository;
import com.example.transactionmicroservice.util.Message;
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
            if(toBalance>balance ||toBalance==0){
                return balance;
            }
            else {
                balance = balance - toBalance;
                return balance;
            }
        }

        if ("deposit".equals(typeOfOperation)) {
            if(toBalance==0){
                return balance;
            }else {
                balance = balance + toBalance;
                return balance;
            }

        }

        return balance;
    }


    public Transaction createTransaction(Transaction transaction){
        Message message =new Message();
        if(transaction.getBalance()==operation(transaction)){
            if (transaction.getToBalance()==0){
                message.setState("error");
                message.setMessage("your input must be greater than 0$ ! ");
                transaction.setMessage(message);
                return transaction;
            }
            message.setState("error");
            message.setMessage("The amount to be withdrawn is greater than your balance !");
            transaction.setMessage(message);
            return transaction;
        }else {
            transaction.setFinalBalance(operation(transaction));
            message.setState("success");
            message.setMessage("your transaction has ben based");
            transaction.setMessage(message);
            return    transactionRepository.save(transaction);

        }
    }

}
