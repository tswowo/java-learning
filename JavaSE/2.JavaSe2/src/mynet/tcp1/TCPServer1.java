package mynet.tcp1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1 {
    public static void main(String[] args) throws Exception {
        //TCP通信下的服务端开发
        //1.创建服务端对象
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.阻塞,等待客户端连接
        Socket socket = serverSocket.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.包装一下输入流
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readInt());
        System.out.println((char)dis.read());
        byte[]bs=new byte[3];
        dis.readFully(bs);
        System.out.println(new String(bs).trim());
        System.out.println(dis.readUTF());
        while (true) {
            String input = dis.readUTF().trim();
            System.out.println(input);
            if (input.equals("exit"))
                break;
        }
        System.out.println("接收完毕");
        System.out.println(socket.getInetAddress().getHostAddress()+":"+socket.getPort());
    }
}
