package com.xhonell;

import com.xhonell.util.JDBC;
import com.xhonell.view.Index;

/**
 * Hello world!
 */
public class MainApp {
    public static final JDBC jdbc = new JDBC();

    /**
     * 主函数入口。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        new Index().index();
    }
}
