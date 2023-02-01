package com.bank.kahuna.api.APIs_project.models;

public class Account{
    private int id;
    private String type;
    private final int accNumber;
    private Long balance;
    private int custId;

    public Account(int id, int accNumber, String type, Long balance, int custId) {
        this.id = id;
        this.accNumber = accNumber;
        this.type = type;
        this.balance = balance;
        this.custId = custId;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }


}
