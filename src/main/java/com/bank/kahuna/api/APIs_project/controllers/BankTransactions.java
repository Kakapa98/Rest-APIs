package com.bank.kahuna.api.APIs_project.controllers;

import com.bank.kahuna.api.APIs_project.models.Account;
import com.bank.kahuna.api.APIs_project.models.Transaction;
import com.bank.kahuna.api.APIs_project.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankTransactions {

    @Autowired
    private TransactionServices transactionServices;

    //Get transactions for the specified accNumber
    @GetMapping("/getTransaction/{accNumber}")
    public List<Transaction> getTransactionsForAccount(@PathVariable("accNumber") int accNumber){
        return transactionServices.getTransactionsList(accNumber);
    }

    @PostMapping("/withdrawal/{accNumber}")
    public String getWithdrawalForAccount(@RequestBody final Transaction transaction, @PathVariable("accNumber") int accNumber){
        return transactionServices.withdrawal(transaction, accNumber);
    }

    @PostMapping("/deposit/{accNumber}")
    public String depositForAccount(@RequestBody final Transaction transaction, @PathVariable("accNumber") int accNumber){
        return transactionServices.deposit(transaction, accNumber);
    }

    @PostMapping("/sendCash/{accNumber}")
    public String sendCashForAccount(@RequestBody final Transaction transaction, @PathVariable("accNumber") int accNumber){
        return transactionServices.cashSend(transaction, accNumber);
    }
}
