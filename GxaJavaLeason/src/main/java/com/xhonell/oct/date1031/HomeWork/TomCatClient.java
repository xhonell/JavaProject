package com.xhonell.oct.date1031.HomeWork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * <p>Project:JavaProject - TomCatClient
 * <p>POWER by xhonell on 2024-10-31 20:23
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class TomCatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4060);
        System.out.println("连接成功");

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String socketStr = "";
        while (!socketStr.equals("拜拜")) {
            System.out.print("xhonell：");
            socketStr = new Scanner(System.in).nextLine();
            bufferedWriter.write(socketStr);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("TomCat:" + bufferedReader.readLine());
        }

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
