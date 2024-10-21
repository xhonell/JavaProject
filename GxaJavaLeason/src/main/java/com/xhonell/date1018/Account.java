package com.xhonell.date1018;

public class Account {

    private Integer id;
    private Double balance;
    private String passWord;

    public Account() {
    }


    public Account(Integer id, Double balance, String passWord) {
        this.id = id;
        this.balance = balance;
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord.length() == 6) {
            this.passWord = passWord;
            System.out.println("密码设置成功");
        } else {
            System.out.println("密码长度必须为6位");
        }
    }

    @Override
    public String toString() {
        return "账户" + id + "\t" + " 工资" + balance + "\t";
    }
}
