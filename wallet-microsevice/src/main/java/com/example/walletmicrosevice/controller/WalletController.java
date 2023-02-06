package com.example.walletmicrosevice.controller;

import com.example.walletmicrosevice.dto.WalletDto;
import com.example.walletmicrosevice.entity.Wallet;
import com.example.walletmicrosevice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {



     @Autowired
     WalletService walletService;

    @PostMapping("/generateWallet")
    public Wallet generateWallet(@RequestBody WalletDto walletDto){
        return walletService.generateWallet(walletDto) ;
    }

    @GetMapping(path = "getWalletByOwner")
    public Optional<Wallet> displayWalletByOwner(@RequestBody Wallet wallet){
        return walletService.displayWalletByOwner(wallet.getOwner());
    }


    @PutMapping(path = "/updateWallet")
    public Optional<Wallet> updateWallet(@RequestBody Wallet wallet){
        return Optional.ofNullable(walletService.updateWallet(wallet.getBalance(), wallet.getReferenceWallet()));
    }
}
