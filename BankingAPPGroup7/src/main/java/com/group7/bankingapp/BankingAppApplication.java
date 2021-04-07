package com.group7.bankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class BankingAppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BankingAppApplication.class, args);
    }
}
