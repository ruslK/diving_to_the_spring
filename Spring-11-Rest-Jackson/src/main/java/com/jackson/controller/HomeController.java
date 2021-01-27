package com.jackson.controller;

import com.jackson.entities.Account;
import com.jackson.entities.User;
import com.jackson.repositories.AccountRepository;
import com.jackson.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class HomeController {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllusers() {
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts() {
        return accountRepository.findAll();
    }
}
