package com.xhonell;

import com.xhonell.util.JDBC;
import com.xhonell.view.Index;

/**
 * Hello world!
 */
public class MainApp {
    public static final JDBC jdbc = new JDBC();

    public static void main(String[] args) {
        new Index().index();
    }
}
