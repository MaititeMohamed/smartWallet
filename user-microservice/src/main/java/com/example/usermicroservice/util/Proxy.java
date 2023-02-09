package com.example.usermicroservice.util;


import com.example.usermicroservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "wallet",url = "http://localhost:8082/wallet/")
public interface Proxy {

    @GetMapping(path = "/getWalletByOwnerCin/{ownerCin}")
    WalletDto displayWalletByOwnerCin(@PathVariable("ownerCin") String ownerCin);

    @PostMapping("/generateWallet")
    WalletDto generateWallet(@RequestBody WalletDto walletDto);
}
