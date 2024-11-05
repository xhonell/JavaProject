package com.xhonell.oct.date1031.HomeWork;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;

/**
 * <p>Project:JavaProject - TomCatService
 * <p>POWER by xhonell on 2024-10-31 19:56
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class TomCatServer {

    public static void main(String[] args) throws IOException {
        /*创建TomCat服务器*/
        ServerSocket serverSocket = new ServerSocket(4060);
        System.out.println("==服务器等待连接==");
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "已连接");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String str = "";
        while(!(str= bufferedReader.readLine()).equals("拜拜")){
            bufferedWriter.write(tomHashMap(str));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();

    }

    public static String tomHashMap(String str) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("你好", "您好！我的主人,我是人机TomCat");
        hashMap.put("新年好","现在距离新年还有"+ ((new Date(2025,0,1).getTime() - System.currentTimeMillis())/3600 + "小时"));
        hashMap.put("xhonell", "他是一个伟大的添砖Java师");
        hashMap.put("拜拜", "再见,期待您的下次光临");

        for (HashMap.Entry<String,String> entry : hashMap.entrySet()) {
            if (str.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return "我是人机，我不知道你再说什么";
    }
}
