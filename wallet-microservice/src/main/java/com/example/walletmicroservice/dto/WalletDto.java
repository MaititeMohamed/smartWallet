package com.example.walletmicroservice.dto;

import com.example.walletmicroservice.util.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class WalletDto {

    private Long id;
    private Float balance;
    private  String Owner ;
    private  String referenceWallet;

    private Message message;
}
