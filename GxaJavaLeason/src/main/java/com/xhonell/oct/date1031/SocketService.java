package com.xhonell.oct.date1031;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * <p>Project:JavaProject - SocketService
 * <p>POWER by xhonell on 2024-10-31 10:14
 * <p>description：TCP通信服务器端
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class SocketService {

    public static void main(String[] args) throws IOException {
        int part = 10112;
        System.out.println("创建服务器成功");
        ServerSocket serverSocket = new ServerSocket(part);
        new Thread(() -> {
            System.out.println("等待客户端连接");
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String message = "";
            while (!message.equals("拜拜")) {
                try {
                    message = bufferedReader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("客户端(请求)说:" + message);
                System.out.println("请输入回复(响应)内容:");
                message = new Scanner(System.in).next();
                try {
                    bufferedWriter.write(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    bufferedWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }
}
