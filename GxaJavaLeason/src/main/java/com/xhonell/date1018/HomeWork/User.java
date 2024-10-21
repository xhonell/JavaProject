package com.xhonell.date1018.HomeWork;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String userPassword;
    public static int count = 0;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {
    }

    public void register() {
        com.xhonell.date1018.HomeWork.Data data = new com.xhonell.date1018.HomeWork.Data();
        data.addUser(this.getUserName(), this.getUserPassword());

    }

}
