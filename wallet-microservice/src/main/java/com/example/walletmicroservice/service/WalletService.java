package com.example.walletmicroservice.service;

import com.example.walletmicroservice.dto.DtoConvert;
import com.example.walletmicroservice.dto.WalletDto;
import com.example.walletmicroservice.entity.Wallet;
import com.example.walletmicroservice.repository.WalletRepository;
import com.example.walletmicroservice.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;
    //generate Wallet
    public Wallet generateWallet(WalletDto walletDto){
    Message message=new Message();
    Wallet wallet = DtoConvert.WalletDtoToEntity(walletDto);
    if(wallet.getBalance()==null || wallet.getBalance()==0 || wallet.getOwner()==null || wallet.getOwner()==""){
        message.setState("Error");
        message.setMessage("Pleas Insert all information");
        wallet.setMessage(message);
        return  wallet;
    }

        message.setState("Success");
        message.setMessage("Wallet has ben created");
        wallet.setMessage(message);
        String RefWallet = UUID.randomUUID().toString();
        wallet.setReferenceWallet(RefWallet);
        walletRepository.save(wallet);
        return  wallet;


    }


}
