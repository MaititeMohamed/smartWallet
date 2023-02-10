package com.example.transactionmicroservice.util;


import com.example.transactionmicroservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(value = "wallet",url = "http://localhost:8082/wallet/")
public interface Proxy {


    @GetMapping(path = "/getWalletByOwnerCin/{ownerCin}")
    WalletDto displayWalletByOwnerCin(@PathVariable("ownerCin")String ownerCin);

    @GetMapping(path = "/getWalletByReferenceWallet/{referenceWallet}")
    WalletDto getWalletByReferenceWallet(@PathVariable("referenceWallet") String referenceWallet);

    @PutMapping(path = "/updateWallet")
    WalletDto updateWallet(@RequestBody WalletDto walletDto);
}
