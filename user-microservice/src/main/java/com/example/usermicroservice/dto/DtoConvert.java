package com.example.usermicroservice.dto;

import com.example.usermicroservice.entity.User;
import org.modelmapper.ModelMapper;

public class DtoConvert {
    public static User UserDtoToEntity(UserDto dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto,User.class);
    }
    public static UserDto UserEntityToDto(User user){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user,UserDto.class);
    }

}
