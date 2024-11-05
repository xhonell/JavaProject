package com.xhonell.oct.date1031.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * web 项目
 * 服务器
 *
 * @author 930437
 * 要求： 使用ServerSocket启动8080端口，
 * 监听客户端连接 将与客户端连接的Socket保存在Vector 数组中 开启一个接收该客户端消息的线程
 */
public class Server implements Runnable {

    //服务器
    ServerSocket ss = null;
    //端口号
    int port = 8081;

    //所以的客户端的套接字  == 存储Socket信息 线程安全
    static Vector<Socket> arr = new Vector<>(); //数组  线程安全
    static Hashtable hash = new Hashtable();

    //构造器
    public Server() {
        new Sensitive();
    }

    public Server(int port) { // 带参构造，指定ServerSocket绑定端口号
        this.port = port;
        new Sensitive();
    }

    @Override
    public void run() {//并发代码块
        try {
            ss = new ServerSocket(port); // 绑定端口号
            while (true) {
                Socket cs = ss.accept(); // 开启监听
                if (cs.isClosed()) {
                    System.out.println("有个小黑子尝试访问服务器！");
                }

                hash.forEach((k, v) -> {
                    if (hash.containsKey(k)) {
                        if (System.currentTimeMillis() - (Long) v <= 60 * 1000) {
                            DataOutputStream dos = null;
                            try {
                                dos = new DataOutputStream(cs.getOutputStream());
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                            try {
                                dos.writeUTF("你个黑名单你还上号干嘛！"); // 转发回去
                                dos.flush();//刷新缓冲流 立即推送
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            } finally {
                                try {
                                    cs.close();
                                } catch (IOException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                });
                //cs 有新的客户端 来了  保存到集合中
                if (!cs.isClosed()) {
                    System.out.println("连接成功," + cs.getInetAddress().getHostAddress());
                    arr.add(cs); // 将当前Socket信息存储到集合
                    //为这个客户端单独起一个线程
                    new Rec_Sen_Thread(cs).start(); // 开启服务器消息接收并转发线程
                } else {
                    System.out.println("小黑子尝试访问失败：" + cs.getInetAddress().getHostAddress());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Rec_Sen_Thread extends Thread { // 服务器接收消息并转发
        // 通信
        Socket cs = null;

        public Rec_Sen_Thread(Socket cs) {
            this.cs = cs;
        }

        @Override
        public void run() {//并且
            if (cs.isClosed())
                return;
            //数据输入流

            DataInputStream dis = null; // 输入流
            try {
                dis = new DataInputStream(cs.getInputStream());
                // str对话数据
                String str = "";
                String ai = "您好，我是子麒同学！";

                //  是不是空
                while (str != null) { // 读取数据
                    if (cs.isClosed())
                        return;
                    try {
                        str = dis.readUTF();//
                    } catch (EOFException e) {//读取到末尾
                        str = "";
                        break;
                    }
                    {

                        for (String s : Sensitive.sensitive) {
                            if (str.contains(s)) {
                                str = cs.getInetAddress() + "： 因为语言不和谐，就只能把他人给和谐了";
                                arr.remove(cs);
                                Long date = System.currentTimeMillis();
                                hash.put(cs, date);
                                cs.close();
                                break;
                            }
                        }

                        /*AI私聊，有可能进入循环导致其他线程抢不到，我不太清楚，没测试过多人*/
                        if (str.contains("召唤AI")) {

                            DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
                            dos.writeUTF(ai);
                            String s = str;
                            while (true) {
                                s = dis.readUTF(new DataInputStream(cs.getInputStream()));
                                if (s.contains("退出"))
                                    break;
                                dos.writeUTF("子琪同学：" + tomHashMap(s));
                                dos.flush();
                            }
                        }
                    }
                    //输出
                    System.out.println(cs.getInetAddress().getHostAddress() + ":" + str);

                    try {
                        //循环 所有客户端

                        for (Socket socket : arr) { // 轮询发送
                            //不给消息来源客户端转发它自己的消息
                            if (cs != socket && !socket.isClosed()) { //转发所有客户端 (除开我自己)
                                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                                dos.writeUTF(str); // 转发消息  服务转发所有客户端新的信息
                                dos.flush();//刷新缓冲流 立即推送
                                // System.out.println(str);
                            }
                            //
                            if (socket.isClosed()) {
                                arr.remove(socket);//移除 这个 套接字
                            }
                        }


                    } catch (ConcurrentModificationException e) {
                        System.out.println("有人异常遍历数组");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void main(String[] args) {
        Server server = new Server();
        new Thread(server).start(); // 开启线程
    }

    public String tomHashMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("你好", "您好！我是人机");
        hashMap.put("新年好", "现在距离新年还有" + ((new Date(2025, 0, 1).getTime() - System.currentTimeMillis()) / 360000 / 24 + "天"));
        hashMap.put("xhonell", "他是一个伟大的添砖Java师");
        hashMap.put("早上好", "早上好！祝您一天都有好心情！");
        hashMap.put("晚上好", "晚上好！愿您有一个美好的夜晚！");
        hashMap.put("谢谢", "不客气，很高兴能帮到您！");
        hashMap.put("如何学习Java", "学习Java可以从基础语法开始，然后逐步学习面向对象、集合框架、异常处理等高级特性。推荐您阅读《Java核心技术卷I》和参加在线课程。");
        hashMap.put("天气", "请告诉我您所在的城市，我可以帮您查询最近的天气情况。");
        hashMap.put("学编程", "编程是一项很好的技能，您可以从Python、Java或JavaScript等语言中选择一门开始学习。初学者可以尝试使用在线教程和编程练习平台。");
        hashMap.put("你是谁", "我是一个人工智能助手，专门为您提供帮助和解答问题。");
        hashMap.put("书推荐", "这取决于您的兴趣领域。如果是技术书籍，可以看看《代码大全》、《设计模式》；如果是小说，可以阅读《三体》、《解忧杂货店》等。");
        hashMap.put("再见", "再见，期待与您的下次交流！");

        for (HashMap.Entry<String, String> entry : hashMap.entrySet()) {
            if (str.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "我是人机，我不知道你再说什么";
    }
}
