package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.dto.WalletDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.service.UserService;
import com.example.usermicroservice.util.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/SmartWallet/User")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Proxy proxy;

    /*  start wallet microservice*/
    @GetMapping(path = "/getWalletByOwnerCin/{ownerCin}")
    public WalletDto displayWalletByOwnerCin(@PathVariable("ownerCin") String ownerCin){
        return proxy.displayWalletByOwnerCin(ownerCin);
    }
    @PostMapping("/generateWallet")
    public  WalletDto generateWallet(@RequestBody WalletDto walletDto){
        return proxy.generateWallet(walletDto);
    }
    /* End  wallet microservice*/
    @GetMapping(path = "/getUserByEmail/{email}")
   public Optional<User> getByEmail(@PathVariable("email") String email){
      return userService.getUserByEmail(email);
    }
    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping(path = "/getUserByCin/{cin}")
    public Optional<User> getUserByCin(@PathVariable("cin") String cin){
    return  userService.getUserByCin(cin);
    }
    @PostMapping ("/registre")
    public User registre(@RequestBody UserDto userDto){
        return userService.registre(userDto);
    }

}
