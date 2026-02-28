package mynet.tcp1;

import java.io.*;
import java.net.*;

public class TCPServer2 {
    public static void main(String[] args) throws Exception {
        //TCP通信下的服务端开发 处理多个客户端请求
        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            Socket socket = ss.accept();
            new Thread(new ServerThread(socket)).start();
            synchronized (TCPServer2.class) {
                System.out.println("当前连接数：" + ServerThread.count);
            }
        }
    }
}

class ServerThread implements Runnable {
    Socket socket;
    InetAddress address;
    static int count = 0;

    public ServerThread(Socket socket) {
        this.socket = socket;
        address = socket.getInetAddress();
        synchronized (TCPServer2.class){
            count++;
        }
    }

    @Override
    public void run() {
        try {
            //1.获取输入流
            InputStream is = socket.getInputStream();
            //2.包装输入流
            DataInputStream dis = new DataInputStream(is);
            //3.读取数据
            String input;
            String ip = address.getHostAddress();
            int port = socket.getPort();
            System.out.println(ip + ":" + port + "已连接");
            while (true) {
                input = dis.readUTF();
                if (input.equals("exit"))
                    break;
                System.out.print("来自" + ip + ":" + port + "的数据：");
                System.out.println(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (TCPServer2.class) {
            count--;
        }
        System.out.println("客户端" + Thread.currentThread().getName() + "已退出");
    }
}
