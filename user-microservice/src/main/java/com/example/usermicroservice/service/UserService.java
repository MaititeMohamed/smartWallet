package com.example.usermicroservice.service;

import com.example.usermicroservice.dto.DtoConvart;
import com.example.usermicroservice.dto.UserDto;
import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.example.usermicroservice.util.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public Optional<User> getUserByEmail(String email){
        return  userRepository.findUserByEmail(email);
    }

    public  Optional<User> getUserByCin(String cin){
        return userRepository.findByCin(cin);
    }

    public Optional<User> checkIfUserExists(User user){
       return userRepository.findByCinOrEmail(user.getCin(),user.getEmail());
    }
    public User  registre(UserDto userDto){

        Message message =new Message();
        User user = DtoConvart.UserDtoToEntity(userDto);
        Optional<User> userByEmailAndCin=checkIfUserExists(user);
        if(user.getEmail()==null || user.getEmail()=="" || user.getFirstName()==null || user.getFirstName()==""
         ||user.getLastName()==null ||user.getLastName()=="" ||user.getCin()==null ||user.getCin()==""
         ||user.getPassword()==null ||user.getPassword()==""
        ){
            message.setState("Error");
            message.setMessage("Pleas Insert all information");
            user.setMessage(message);
            return  user;
        }

        if(userByEmailAndCin.isPresent()){
            message.setState("Error");
            message.setMessage("This User is Already exist");
            user.setMessage(message);
            return  user;
        }

        userRepository.save(user);
        message.setState("Success");
        message.setMessage("User has ben created");
        user.setMessage(message);
        return  user;
    }




}
