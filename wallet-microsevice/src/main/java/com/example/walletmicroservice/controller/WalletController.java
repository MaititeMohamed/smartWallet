package com.example.walletmicroservice.controller;

import com.example.walletmicroservice.dto.WalletDto;
import com.example.walletmicroservice.entity.Wallet;
import com.example.walletmicroservice.service.WalletService;
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

    @GetMapping(path = "/getWalletByOwnerCin/{ownerCin}")
    public Optional<Wallet> displayWalletByOwnerCin(@PathVariable("ownerCin") String ownerCin){
        return walletService.displayWalletByOwnerCin(ownerCin);
    }

    @PutMapping(path = "/updateWallet")
    public Optional<Wallet> updateWallet(@RequestBody Wallet wallet){
        return Optional.ofNullable(walletService.updateWallet(wallet.getBalance(), wallet.getReferenceWallet()));
    }
}
