package com.example.walletmicroservice.dto;

import com.example.walletmicroservice.entity.Wallet;
import org.modelmapper.ModelMapper;

public class DtoConvert {


    public static Wallet walletDtoToEntity(WalletDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Wallet.class);
    }
    public static WalletDto walletEntityToDto(Wallet user){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user,WalletDto.class);
    }
}
