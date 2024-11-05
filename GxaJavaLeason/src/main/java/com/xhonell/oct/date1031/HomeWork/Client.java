package com.xhonell.oct.date1031.HomeWork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * day13.t1
 * User: hly
 * Date: 2024/04/01 10:51
 * Description:
 * Version: V1.0
 */

/**
 * 要求： 客户端开启发送消息和接收消息线程
 */

public class Client implements Runnable {
    Socket cs = null;
    String nick = null;
    //    String host="172.16.104.138"; // 远端服务器名称和端口
    /*自己玩*/
    String host = " 192.168.47.184";
    int port = 8081;

    public Client() {
        new Sensitive();
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        new Sensitive();
    }

    @Override
    public void run() {
        try {
            cs = new Socket(host, port); // 建立连接
            /*AtomicBoolean isFlag = new AtomicBoolean(true);
            while(isFlag.get()){*/
            System.out.println("请输入你的昵称:"); // 只输出昵称提示
            nick = new Scanner(System.in).next();
             /*   Sensitive.sensitive.forEach(s -> {
                    if(!nick.contains(s)) {
                        System.out.println("你的名字不太合法，再给你一个机会吧！");
                        isFlag.set(true);

                    }else{
                        isFlag.set(false);
                    }

                });
            }*/

            System.err.println("连接成功，请注意文明交流喔！");
            // 读
            new RecThread(cs).start(); // 解决接收数据时产生的阻塞
            // 写
            new SendThread(cs).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class RecThread extends Thread { // 接收消息线程
        Socket cs = null;

        public RecThread(Socket cs) {
            this.cs = cs;
        }

        public void run() {
            String str;
            DataInputStream dis = null;
            try {
                dis = new DataInputStream(cs.getInputStream());// 输入流
                while ((str = dis.readUTF()) != null) { // 网络阻塞点，读取数据
                    System.out.println(str); // 消息打印在控制台，模拟客户端收到消息
                }
            } catch (IOException e) {
                System.out.println("粗去！");
                interrupt();


            } finally { // 释放资源
                if (dis != null) {
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class SendThread extends Thread { // 客户端发送线程
        Socket cs = null;

        public SendThread(Socket cs) {
            this.cs = cs;
        }

        public void run() {
            String str = "";
            DataOutputStream dos = null;

            try {
                Scanner input = new Scanner(System.in); // 客户端输入消息
                if (cs.isClosed()) return;
                dos = new DataOutputStream(cs.getOutputStream()); // 输出流
                while (str != null) { // 键盘阻塞
                    if (cs.isClosed())
                        return;
                    Thread.sleep(100);
                    System.err.print("请输入要说的话:");
                    str = input.next();
                    if ("886".equals(nick + ":" + str)) { // 客户端结束聊天，主动断开Socket连接
                        dos.writeUTF("Byebye!");
                        dos.flush();
                        break;
                    }
                    // 将消息中的真实 IP 地址替换为假的 IP 地址
                    String fakeIp = "添砖Java师"; // 假的 IP 地址
                    dos.writeUTF(fakeIp + nick + ": " + str); // 输出
                    dos.flush(); // 立即从缓冲发送
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally { // 释放资源
                if (dos != null) {
                    try {
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Client c = new Client("localhost", 8081);
        {
            System.out.println("请输入内部密码：");
            String passWord = new Scanner(System.in).next();
            if ("做大做强，再创辉煌".equals(passWord)) {
                System.err.println("密码正确！你好，天选打工人！");
                new Thread(c).start();
            } else {
                System.out.println("密码不对，问问旁边的盆友！");
            }
        }

    }
}
