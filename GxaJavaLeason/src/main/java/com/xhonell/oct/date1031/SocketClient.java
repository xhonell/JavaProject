package com.xhonell.oct.date1031;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * <p>Project:JavaProject - SocketClient
 * <p>POWER by xhonell on 2024-10-31 10:24
 * <p>description：TCP通信客户器端
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class SocketClient {

    public static void main(String [] args) throws IOException {
        String IP = "localhost";
        int port = 10112;

        Socket socket = new Socket(IP,port);
        System.out.println("服务器连接成功");
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String message = "";
        while(! message .equals("拜拜")  ){
            System.out.println("请输入要发送(请求)给服务器的对话:");
            message=new Scanner(System.in).nextLine();//把内容返回字符串 但是里面并没有包含换行符
            bufferedWriter.write(message);
            bufferedWriter.newLine();//换行
            bufferedWriter.flush();//刷新缓冲区
            message=bufferedReader.readLine();
            System.out.println("服务器响应的内容说:"+message);
        }

        bufferedWriter.close();
        socket.close();

    }
}
