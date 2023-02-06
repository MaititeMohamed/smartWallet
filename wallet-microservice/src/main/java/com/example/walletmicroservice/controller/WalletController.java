package com.example.walletmicroservice.controller;


import com.example.walletmicroservice.dto.WalletDto;
import com.example.walletmicroservice.entity.Wallet;
import com.example.walletmicroservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping(path = "/generateWallet")
    public Wallet generateWallet(@RequestBody  WalletDto walletDto){
        return walletService.generateWallet(walletDto);
    }

}
