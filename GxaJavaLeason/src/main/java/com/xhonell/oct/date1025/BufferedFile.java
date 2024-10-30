package com.xhonell.oct.date1025;

import java.io.*;

/**
 * <p>Project:JavaProject - BufferedFile
 * <p>POWER by xhonell on 2024-10-25 14:14
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class BufferedFile {

    public void bufferedFileRead() throws IOException {

        FileReader fileReader = new FileReader("F:\\Users\\xhonell\\Documents\\论文\\《大学生考研信息查询系统的设计与实现》.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Long time = System.currentTimeMillis();
        FileWriter fileWriter = new FileWriter("F:\\Users\\《大学生考研信息查询系统的设计与实现》.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        char[] buffer = new char[1024];
        int length;
        while ((length = bufferedReader.read(buffer)) != -1) {
            bufferedWriter.write(buffer, 0, length);
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        System.out.println(System.currentTimeMillis() - time);
    }
}
