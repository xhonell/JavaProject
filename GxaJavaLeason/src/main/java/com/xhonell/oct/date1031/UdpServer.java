package com.xhonell.oct.date1031;

import com.xhonell.oct.date1018.HomeWork.Data;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * <p>Project:JavaProject - UdpServer
 * <p>POWER by xhonell on 2024-10-31 15:19
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[1024];
        //创建数据包
        DatagramPacket datagramPacket = new DatagramPacket(arr, 0, arr.length);
        //创建服务器
        DatagramSocket socket = new DatagramSocket(8581);
        //解析数据
        socket.receive(datagramPacket);//把客户端发送的信息 装入数据包 数据包再把数据解析到arr数组中
        System.out.println(new String(arr).trim());
        socket.close();
    }

}
