package com.xhonell.oct.date1025.HomeWork;

import java.io.*;

/**
 * <p>Project:JavaProject - exchangeFile
 * <p>POWER by xhonell on 2024-10-26 09:34
 * description：文件内容进行交换
 * 思路：两文件无法实现直接交换，通过中间文件temp实现
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class ExchangeFile {

    public String readFile(String src) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
        char[] buffer = new char[1024];
        StringBuffer stringBuffer = new StringBuffer();
        int numRead = 0;
        while ((numRead = bufferedReader.read(buffer)) != -1) {
            stringBuffer.append(buffer, 0, numRead);
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    /**
     * 将字符串写入txt文档中
     *
     * @param src
     * @param file
     * @throws IOException
     */
    public void writeFile(String src, String file) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(src));
        bufferedWriter.write(file);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
