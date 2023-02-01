package com.bank.kahuna.api.APIs_project.services;


import com.bank.kahuna.api.APIs_project.models.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountServices {

    private static List<Account> accountList = new ArrayList<Account>();

    static {
        accountList.add(new Account(1, 1015436851,"Savings",5000L,2));
        accountList.add(new Account(2, 1015987456, "Cheque", 10000L,1));
        accountList.add(new Account(3, 1015104578, "Car", 7500L, 2));
        accountList.add(new Account(4, 1015610487, "Interest", 3500L, 3));

    }

    //Get all the accounts
    public List<Account> getAccountList() {
        return accountList;
    }

    //Get a single account
    public Account getAccountById(int id) {
        return accountList.stream().filter(e -> e.getId() == (id)).findFirst().get();
    }

    //Get account by accountNumber
    public Account getAccountByAccountNumber(int accountNumber) {
        return accountList.stream().filter(e -> e.getAccNumber() == (accountNumber)).findFirst().get();
    }

    //Creating a new account
    public void addingAccount(Account account) {
        AccountServices.accountList.add(account);
    }

    //Updating an account
    public void updatingAccount(Account account, int id){
        accountList.stream().map(b -> {
            if (b.getId() == id){
                b.setType(account.getType());
            }
            return b;
        }).collect(Collectors.toList());
    }

    //Delete an account
    public void deleteAccount(int id){
        accountList = accountList.stream().filter(account -> account.getId() == id).collect(Collectors.toList());
    }
}
