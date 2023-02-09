package com.example.usermicroservice.dto;

import com.example.usermicroservice.util.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class WalletDto {

    private Long id;
    private  float balance;
    private String ownerCin;
    private String referenceWallet;
    private Message message;

}
