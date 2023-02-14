package com.example.transactionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransactionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionMicroserviceApplication.class, args);
    }

}
