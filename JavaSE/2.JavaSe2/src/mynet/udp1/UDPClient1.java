package mynet.udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient1 {
    public static void main(String[] args) throws Exception {
        //客户端开发
        //1.创建发送端对象
        DatagramSocket socket = new DatagramSocket();
        //2.创建数据包对象封装发送的数据
        Scanner sc = new Scanner(System.in);
        String input;
        //3.发送数据
        do {
            input = sc.nextLine();
            DatagramPacket packet = new DatagramPacket(input.getBytes(), input.getBytes().length, InetAddress.getLocalHost(), 8888);
            socket.send(packet);
        } while (!input.equals("exit"));
        socket.close();
        System.out.println("发送完毕");
    }
}
