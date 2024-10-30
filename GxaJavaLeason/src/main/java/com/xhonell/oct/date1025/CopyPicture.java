package com.xhonell.oct.date1025;


import java.io.*;
import java.util.Arrays;

/**
 * <p>Project:JavaProject - copy
 * <p>POWER by xhonell on 2024-10-25 10:31
 * description：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class CopyPicture {

    public static int lengthIO = 0;

    public static boolean copyPicture(String src, String dest) throws IOException {
        byte[] buffer = fileInputPicture(src);
        fileOutputPicture(src, dest, buffer);
        return true;
    }

    private static byte[] fileInputPicture(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        byte[] buffer = new byte[102400];
        int temp;
        while ((temp = inputStream.read(buffer)) != -1) {
            lengthIO = temp;
        }
        inputStream.close();
        return Arrays.copyOf(buffer, lengthIO);
    }

    private static void fileOutputPicture(String src, String path, byte[] buffer) throws IOException {
        File file = new File(path);
        if (!file.exists())
            System.out.println(file.mkdirs() ? "文件创建成功" : "文件创建失败");
        path = path + "\\" + FileTools.getFullFileName(src);
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(buffer);
        outputStream.close();
    }

    public static void fileReader(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        char[] buffer = new char[1024];
        int length = fileReader.read(buffer);
        fileReader.close();
        fileWriter(Arrays.copyOf(buffer, length));
        System.out.println(Arrays.toString(Arrays.copyOf(buffer, length + 2)));
    }

    public static void fileWriter(char[] buffer) throws IOException {
        String path = "F:\\Users\\xhonell\\Pictures\\开题报告.docx";
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(buffer);
        fileWriter.close();
    }


}
