package com.example.walletmicroservice.service;


import com.example.walletmicroservice.dto.DtoConvert;
import com.example.walletmicroservice.dto.WalletDto;
import com.example.walletmicroservice.entity.Wallet;
import com.example.walletmicroservice.repository.WalletRepository;
import com.example.walletmicroservice.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;


    public  Optional<Wallet> findWalletByOwnerCin(String wallet){
        return walletRepository.findWalletByOwnerCin(wallet);
    }

    public Wallet  generateWallet(WalletDto walletDto) {
        Message message = new Message();
        Optional<Wallet> existWallet=findWalletByOwnerCin(walletDto.getOwnerCin());
        Wallet wallet = DtoConvert.walletDtoToEntity(walletDto);
      if(wallet.getOwnerCin()==null ||wallet.getOwnerCin()==""){
          message.setState("Error");
          message.setMessage("Pleas Insert all information");
          wallet.setMessage(message);
          return  wallet;
      }
      if(existWallet.isPresent()){
          message.setState("Error");
          message.setMessage("wallet already exist ");
          wallet.setMessage(message);
          return  wallet;
      }
        message.setState("Success");
        message.setMessage("wallet has ben created");
        wallet.setMessage(message);
        String RefWallet = String.valueOf(UUID.randomUUID());
        wallet.setReferenceWallet(RefWallet);
        wallet.setBalance(0);
        walletRepository.save(wallet);
        return wallet;
    }

  public Optional<Wallet> displayWalletByOwnerCin(String wallet){
        return walletRepository.findWalletByOwnerCin(wallet);
  }

  public Optional<Wallet>  findWalletByReference(String referenceWallet){
  return walletRepository.findWalletByReferenceWallet(referenceWallet);
  }

  public Wallet updateWallet(float balance,String referenceWallet){

        Optional<Wallet> existWallet=findWalletByReference(referenceWallet);
        Optional<Wallet> wallet=existWallet;
        if(existWallet.isPresent()){
            if(balance>=0){
            wallet.get().setBalance(balance);
            walletRepository.save(wallet.get());
            }
        }

      return  wallet.get();
  }




}
