package com.example.walletmicroservice.dto;

import com.example.walletmicroservice.entity.Wallet;
import org.modelmapper.ModelMapper;

public class DtoConvert {


    public static Wallet WalletDtoToEntity(WalletDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto,Wallet.class);
    }
    public static WalletDto WalletEntityToDto(Wallet wallet){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(wallet,WalletDto.class);
    }
}
