package com.example.usermicroservice.dto;

import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.util.Message;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class UserDto {

    private  Long id;
    private  String firstName;
    private  String  lastName;
    private  String  email;
    private  String  password;
    private  String cin ;

    //mapping
//    public  UserDto toDto(User user){
//     return UserDto.builder()
//             .id(user.getId())
//             .firstName(user.getFirstName())
//             .lastName(user.getFirstName())
//             .email(user.getEmail())
//             .password(user.getPassword())
//             .cin(user.getCin())
//             .build();
//    }



    private Message message;

}
