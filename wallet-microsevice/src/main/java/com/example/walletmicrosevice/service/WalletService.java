package com.example.walletmicrosevice.service;


import com.example.walletmicrosevice.dto.DtoConvert;
import com.example.walletmicrosevice.dto.WalletDto;
import com.example.walletmicrosevice.entity.Wallet;
import com.example.walletmicrosevice.repository.WalletRepository;
import com.example.walletmicrosevice.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;




    public Wallet  generateWallet(WalletDto walletDto) {
        Message message = new Message();
        Wallet wallet = DtoConvert.walletDtoToEntity(walletDto);
      if(wallet.getOwner()==null ||wallet.getOwner()==""){
          message.setState("Error");
          message.setMessage("Pleas Insert all information");
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

  public Optional<Wallet> displayWalletByOwner(String wallet){
        return walletRepository.findWalletByOwner(wallet);
  }

  public Optional<Wallet>  findWalletByReference(String referenceWallet){
  return walletRepository.findWalletByReferenceWallet(referenceWallet);
  }

  public Wallet updateWallet(float balance,String referenceWallet){

        Optional<Wallet> existWallet=findWalletByReference(referenceWallet);
        Optional<Wallet> wallet=existWallet;
        if(existWallet.isPresent()){
            wallet.get().setBalance(balance);
            walletRepository.save(wallet.get());
        }

      return  wallet.get();
  }




}
