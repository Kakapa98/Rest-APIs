package com.bank.kahuna.api.APIs_project.services;

import com.bank.kahuna.api.APIs_project.models.Account;
import com.bank.kahuna.api.APIs_project.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionServices {

    private static List<Transaction> transactionsList = new ArrayList<Transaction>();
    @Autowired
    private static AccountServices accountServices;
    private static  Account account;

    static {
        transactionsList.add(new Transaction(1, 1015436851, "12/01/2023", "Deposit", 1500L, "School Fees"));
        transactionsList.add(new Transaction(2, 1015436851, "15/01/2023", "Deposit", 2000L, "Rent"));
        transactionsList.add(new Transaction(3, 1015436851, "20/01/2023", "EFT", 500L, "McDonald Meal"));
        transactionsList.add(new Transaction(4, 1015104578, "10/01/2023", "Send-Cash", 15500L, "Car Repair"));
        transactionsList.add(new Transaction(5, 1015104578, "13/01/2023", "EFT", 1583L, "Grocery"));

    }

    //Get the list of transactions
    public List<Transaction> getTransactionsList(int accNumber) {
        return transactionsList.stream().filter(t -> t.getAccNumber() == accNumber).collect(Collectors.toList());
    }

    //Make a withdrawal
    public String withdrawal(Transaction transaction, int accNumber) {
        Account acc = accountServices.getAccountByAccountNumber(accNumber);
        if (acc != null) {
            acc.setBalance(acc.getBalance() - transaction.getAmount());
            transactionsList.add(transaction);
        }
        else {
            return "Transaction Failed" + "\nAccount Number does not exist";
        }

        return "Withdrawal is successful";
    }

    //Make a deposit
    public String deposit(Transaction transaction, int accNumber) {
        Account account1 = accountServices.getAccountByAccountNumber(accNumber);
        if (account1 != null) {
            account1.setBalance(account1.getBalance() + transaction.getAmount());
            transactionsList.add(transaction);
        }
        else {
            return "Transaction Failed" + "\nAccount Number does not exist";
        }
        return "Deposit is successful";
    }

    //Make a cash Send
    public String cashSend(Transaction transaction, int accNumber){
        return "Money send is successful";
    }
}
