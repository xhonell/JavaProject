package com.xhonell.date1029;

/**
 * <p>Project:JavaProject - Noodle
 * <p>POWER by xhonell on 2024-10-29 11:27
 * description：面条类
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Noodle {
    public static Integer id = 0;

    public Noodle() {
        id++;
    }

    public String toString() {
        return id.toString();
    }
}
