package com.xhonell.oct.date1021.HomeWork;

import lombok.Data;

@Data
public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(long id, double balance, String accountName, double creditLimit) {
        super(id, balance, accountName);
        this.creditLimit = creditLimit;
    }

    public CreditAccount() {
    }
}
