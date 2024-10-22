package com.xhonell.date1021.HomeWork;

import org.junit.Test;

public class Main {

    /**
     * 测试类：测试questionTwentyFiveTest方法
     */
    @Test
    public void questionTwentyFiveTest() {
        QuestionTwentyFive questionTwentyFive = new QuestionTwentyFive();
        questionTwentyFive.employeeSalary();
    }

    /**
     * 测试类：测试bankTest方法
     */
    @Test
    public void bankTest() {
        Bank bank = new Bank();
        Account account = bank.openAccount(1, "123456", 2);
        System.out.println(account.getId());
        System.out.println("账户余额为：" + bank.deposit(account, 100));
        System.out.println("账户余额为：" + bank.withdraw(account, 100));
    }
}
