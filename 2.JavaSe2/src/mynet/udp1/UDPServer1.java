package mynet.udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer1 {
    public static void main(String[] args) throws Exception {
        //服务端开发
        //1.创建接收端对象
        DatagramSocket socket = new DatagramSocket(8888);
        //2.创建数据包对象封装接收的数据
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        String data ;
        while (true) {
            socket.receive(packet);
            if (packet.getLength() > 0) {
                data = new String(packet.getData(), 0, packet.getLength()).trim();
                if(data.equals("exit"))
                    break;
                System.out.println(data);
                String ip=packet.getAddress().getHostAddress();
                int port=packet.getPort();
                System.out.println(ip+":"+port);
            }
        }
        System.out.println("接收完毕");
        socket.close();
    }
}
