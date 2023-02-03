package com.example.wallemicroservice.dto;

import lombok.Builder;

@Builder
public class WalletDto {

    private Long id;
    private Float balance;
    private  String Owner ;
    private  String referenceWallet;
}
