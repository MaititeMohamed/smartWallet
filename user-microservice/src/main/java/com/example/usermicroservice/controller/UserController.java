package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/SmartWallet/User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserByEmail")
    public Optional<User> getUserByEmail(@RequestBody User user){
        return userService.getUserByEmail(user.getEmail());
    }
    @GetMapping(path = "/getUserByCin")
    public Optional<User> getUserByCin(@RequestBody User user){
    return  userService.getUserByCin(user.getCin());
    }
    @PostMapping ("/registre")
    public User registre(@RequestBody UserDto userDto){
        return userService.registre(userDto);
    }

}
