package com.acme.banking.dbo.spring.controller;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Resource private AccountRepository accounts;

    @GetMapping("/accounts")
    public Collection<Account> getAllAccounts() {
        return accounts.findAll();
    }
}
