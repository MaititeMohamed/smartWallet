package com.example.transactionmicroservice.util;
import com.example.transactionmicroservice.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wallet-microservice")
public interface Proxy {


    @GetMapping(path = "/wallet/wallet/getWalletByOwnerCin/{ownerCin}")
    WalletDto displayWalletByOwnerCin(@PathVariable("ownerCin")String ownerCin);

    @GetMapping(path = "/wallet/wallet/getWalletByReferenceWallet/{referenceWallet}")
    WalletDto getWalletByReferenceWallet(@PathVariable("referenceWallet") String referenceWallet);

    @PutMapping(path = "/wallet/wallet/updateWallet")
    WalletDto updateWallet(@RequestBody WalletDto walletDto);
}
