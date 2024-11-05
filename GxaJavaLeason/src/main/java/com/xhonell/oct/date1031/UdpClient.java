package com.xhonell.oct.date1031;

import java.io.IOException;
import java.net.*;

/**
 * <p>Project:JavaProject - UdpClient
 * <p>POWER by xhonell on 2024-10-31 15:28
 * <p>description：
 * <p>idea：
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        //① 定义发送信息
        byte   []  arr="我是你爹".getBytes();
        // ② 创建DatagramPacket，包含将要发送的信息  把数据打包
        DatagramPacket datagramPacket=new DatagramPacket(arr,0,arr.length, InetAddress.getByName("172.16.104.226"),8080);
        //  ③ 创建DatagramSocket                                   自身                                                   服务器的
        DatagramSocket datagramSocket=new DatagramSocket(8081);
        //  ④ 发送数据
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
