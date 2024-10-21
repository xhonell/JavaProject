package com.xhonell.date1021.HomeWork;

public class Bank {

    public Account openAccount(long id, String password, int type) {
        switch (type) {
            case 0:
                return new Account(id, 0, password);
            case 1:
                return new SavingAccount(id, 0, password, 0.04);
            case 2:
                return new CreditAccount(id, 0, password, 10000);
        }
        return null;
    }

    public double deposit(Account a, double amount) {
        a.setBalance(a.getBalance() + amount);
        return a.getBalance();
    }

    public double withdraw(Account a, double amount) {
        if (a instanceof CreditAccount) {
            CreditAccount c = (CreditAccount) a;
            a.setBalance(a.getBalance() - amount);
            if (c.getBalance() > -(c.getCreditLimit())) {
                return a.getBalance();
            } else return -c.getCreditLimit() - 1;
        } else {
            a.setBalance(a.getBalance() - amount);
            if (a.getBalance() < 0) {
                return -1;
            } else return a.getBalance();
        }
    }
}
