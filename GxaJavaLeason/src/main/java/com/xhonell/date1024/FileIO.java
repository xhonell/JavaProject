package com.xhonell.date1024;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <p>Project:JavaProject - FileIO
 * <p>POWER by xhonell on 2024-10-24 16:33
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class FileIO {

    public void fileIO() {
        String path = "F:\\Users\\xhonell\\Documents\\Note\\笔记";
        File file = new File(path);

        System.out.println(file.canRead());
        System.out.println(file.delete());

        if (!file.exists())
            System.out.println(file.mkdirs());

        System.out.println(Arrays.toString(file.list()));

    }
}
