package com.example.transactionmicroservice.service;
import com.example.transactionmicroservice.dto.DtoConvert;
import com.example.transactionmicroservice.dto.TransactionDto;
import com.example.transactionmicroservice.dto.WalletDto;
import com.example.transactionmicroservice.entity.Transaction;
import com.example.transactionmicroservice.repository.TransactionRepository;
import com.example.transactionmicroservice.util.Message;
import com.example.transactionmicroservice.util.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    Proxy proxy;


    public String convertCase(String TransactionType) {
        if (TransactionType.equals(TransactionType.toUpperCase())) {
            return TransactionType.toLowerCase();
        }
          return  TransactionType;
    }
   public float getBalance(String referenceWallet){
       WalletDto walletDto=  proxy.getWalletByReferenceWallet(referenceWallet);
    return    walletDto.getBalance();
   }

    public float operation(Transaction transaction){
    float userBalance = getBalance(transaction.getReferenceWallet());

        String typeOfOperation = convertCase(transaction.getTransactionType());
        float balance = userBalance;
        float amount = transaction.getAmount();

        if ("withdraw".equals(typeOfOperation)) {
            if(amount>balance ||amount==0 ||amount<0){
                return balance;
            }
            else {
                balance = balance - amount;
                return balance;
            }
        }

        if ("deposit".equals(typeOfOperation)) {
            if(amount==0 ||amount<0){
                return balance;
            }else {
                balance = balance + amount;
                return balance;
            }

        }

        return balance;
    }


    public Transaction createTransaction(TransactionDto transactionDto){
        Message message =new Message();
        Transaction transaction = DtoConvert.transactionDtoToEntity(transactionDto);

        if(getBalance(transaction.getReferenceWallet())==operation(transaction)){
            if (transaction.getAmount()==0 || transaction.getAmount()<0){
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
             proxy.updateWallet(WalletDto.builder()
                             .referenceWallet(transaction.getReferenceWallet())
                             .balance(transaction.getFinalBalance())
                     .build());
             transactionRepository.save(transaction);
             return  transaction;

        }
    }

}
