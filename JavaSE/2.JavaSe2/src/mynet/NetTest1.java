package mynet;

import java.net.*;

public class NetTest1 {
    public static void main(String[] args) {
        try {
            InetAddress add=InetAddress.getLocalHost();
            System.out.println(add.getHostName());
            System.out.println(add.getCanonicalHostName());
            System.out.println(add.getHostAddress());
            System.out.println(add);
        } catch (UnknownHostException e) {
            System.out.println("未找到IP");
            System.out.println(e.getMessage());
        }
    }
}