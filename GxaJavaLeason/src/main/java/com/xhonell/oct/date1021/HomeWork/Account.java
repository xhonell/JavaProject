package com.xhonell.oct.date1021.HomeWork;

import lombok.Data;

@Data
public class Account {
    private long id;
    private double balance;
    private String password;

    public Account(long id, double balance, String password) {
        this.id = id;
        this.balance = balance;
        this.password = password;
    }

    public Account() {
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        }
    }

    public String getPassword() {
        return null;
    }
}
