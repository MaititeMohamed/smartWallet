package com.example.transactionmicroservice.dto;

import com.example.transactionmicroservice.entity.Transaction;
import org.modelmapper.ModelMapper;

public class DtoConvert {
    public static Transaction transactionDtoToEntity(TransactionDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto,Transaction.class);
    }
    public static TransactionDto transactionEntityToDto(Transaction transaction){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(transaction,TransactionDto.class);
    }
}
