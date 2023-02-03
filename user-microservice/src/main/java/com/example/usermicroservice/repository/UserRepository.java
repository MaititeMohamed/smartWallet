package com.example.usermicroservice.repository;

import com.example.usermicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User>  findByCin(String cin);


    Optional<User> findByCinOrEmail(String cin,String email);


}
