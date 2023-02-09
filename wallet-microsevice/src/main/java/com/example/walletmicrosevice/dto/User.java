package com.example.walletmicrosevice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private  Long id;
    private  String firstName;
    private  String  lastName;
    private  String  email;
    private  String  password;
    private  String cin ;
}
