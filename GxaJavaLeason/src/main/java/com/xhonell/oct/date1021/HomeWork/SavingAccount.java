package com.xhonell.oct.date1021.HomeWork;

import lombok.Data;

@Data
public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(long id, double balance, String accountName, double interestRate) {
        super(id, balance, accountName);
        this.interestRate = interestRate;
    }

    public SavingAccount() {
    }

    public void setInterestRate(double interestRate) {
        if (interestRate > 0 && interestRate < 0.1) {
            this.interestRate = interestRate;
        }
    }
}
