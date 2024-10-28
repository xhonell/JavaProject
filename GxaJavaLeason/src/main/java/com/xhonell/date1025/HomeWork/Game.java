package com.xhonell.date1025.HomeWork;

import lombok.Data;
import org.junit.Test;

import java.io.Serializable;

/**
 * <p>Project:JavaProject - Game
 * <p>POWER by xhonell on 2024-10-26 18:42
 * description：游戏类别，定义游戏名称，胜率等；
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@Data
public class Game implements Serializable {
    private String gameName;
    private Integer victory;
    private Integer defeat;

    public Game(String gameName){
        this.gameName = gameName;
        victory = 0;
        defeat = 0;
    }

    @Override
    public String toString() {
        return  "游戏名称='" + gameName + '\'' +
                ", 胜利场次=" + victory +
                ", 失败场次=" + defeat + "\n"
                ;
    }
}
