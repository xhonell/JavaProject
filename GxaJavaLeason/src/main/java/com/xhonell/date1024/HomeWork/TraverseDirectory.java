package com.xhonell.date1024.HomeWork;

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
    public static void traverseDirectory(File file) throws FileNotFoundException {

        if (! file.exists())
            throw new FileNotFoundException(file.getAbsolutePath());

        if (file.isDirectory()){
            File[] files = file.listFiles();

            if (files == null)
                throw new FileNotFoundException(file.getAbsolutePath());

            for (File fileOne : files) {
                if (fileOne.isDirectory()) {
                    System.out.println(fileOne.getAbsolutePath());
                    traverseDirectory(fileOne);
                }
                else System.out.println("\t" + fileOne.getAbsolutePath());
            }
        }else System.out.println(file.getAbsolutePath());

    }
}
