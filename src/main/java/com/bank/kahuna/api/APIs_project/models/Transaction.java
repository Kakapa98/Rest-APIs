package com.bank.kahuna.api.APIs_project.models;

public class Transaction {

    int id;
    int accNumber;
    String date;
    String TransactionType;
    Long amount;
    String Reference;

    public Transaction(int id, int accNumber, String date, String transactionType, Long amount, String reference) {
        this.id = id;
        this.accNumber = accNumber;
        this.date = date;
        this.TransactionType = transactionType;
        this.amount = amount;
        this.Reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }
}
