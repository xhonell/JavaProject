package com.xhonell.date1025.HomeWork;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;

/**
 * day8.User
 * User: hly
 * Date: 2024/10/25 14:43
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */
@Data
public class User implements Serializable {//实现序列化接口  自动产生一个编号  唯一的编号
    private String name;
    private Boolean sex;
    private Integer age;
    private String password;
    private Game[] game;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        game = new Game[2];
    }

    public void setGame(Game game, int gameNum) {
        this.game[gameNum] = game;
    }

    public Game getGame(int gameNum) {
        return game[gameNum];
    }

    @Override
    public String toString() {
        return "姓名='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age + '\'' +
                ", game=" + Arrays.toString(game) + "\n";
    }
}
