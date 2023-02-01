package com.bank.kahuna.api.APIs_project.controllers;

import com.bank.kahuna.api.APIs_project.models.Account;
import com.bank.kahuna.api.APIs_project.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankAccount {

    @Autowired
    private AccountServices accountServices;
    @GetMapping("/getAccounts")
    public List<Account> getAccounts() {
        return accountServices.getAccountList();
    }

    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account account) {
        accountServices.addingAccount(account);
        return account;
    }

    @GetMapping("/getAccount/{id}")
    public Account getAccount(@PathVariable("id") int id) {
        return accountServices.getAccountById(id);
    }

    @PutMapping("/updateAccount/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable("id") int id){
        accountServices.updatingAccount(account, id);
        return account;
    }

    @DeleteMapping("/removeAccount/{id}")
    public String removeAccount(@PathVariable("id") int id){
        this.accountServices.deleteAccount(id);
        return "Account deleted";
    }

}
