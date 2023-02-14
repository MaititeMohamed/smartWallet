package com.example.usermicroservice.util;


import com.example.usermicroservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "wallet-microservice")
public interface Proxy {

    @GetMapping(path = "/wallet/wallet/getWalletByOwnerCin/{ownerCin}")
    WalletDto displayWalletByOwnerCin(@PathVariable("ownerCin") String ownerCin);

    @PostMapping("/wallet/wallet/generateWallet")
    WalletDto generateWallet(@RequestBody WalletDto walletDto);
}
