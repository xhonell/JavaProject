package com.xhonell.oct.date1024.HomeWork;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * <p>Project:JavaProject - traverseDirectory
 * <p>POWER by xhonell on 2024-10-24 17:42
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class TraverseDirectory {
    public static void traverseDirectory(File file, String prep) throws FileNotFoundException {

        System.out.println(prep + file.getAbsolutePath());

        if (!file.exists())
            throw new FileNotFoundException(file.getAbsolutePath());

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files == null)
                throw new FileNotFoundException(file.getAbsolutePath());

            for (File fileOne : files) {
                if (fileOne.isDirectory()) {
                    traverseDirectory(fileOne, prep + "\t");
                } else System.out.println(prep + "\t" + fileOne.getAbsolutePath());
            }
        }

    }
}
