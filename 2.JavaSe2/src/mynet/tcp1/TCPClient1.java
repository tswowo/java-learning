package mynet.tcp1;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient1 {
    public static void main(String[] args) throws Exception {
        //TCP通信下的客户端开发
        //1.Socket对象,请求与服务端Socket对象建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.获取输出流
        OutputStream os= socket.getOutputStream();
        //3.包装一下输出流
        DataOutputStream dos=new DataOutputStream(os);
        //4.发送数据
        dos.writeInt(1);
        dos.write('+');
        dos.write("str".getBytes());
        dos.writeUTF("hello world");

        Scanner sc = new Scanner(System.in);
        while (true){
            String
            input = sc.nextLine();
            dos.writeUTF(input);
            dos.flush();
            if(input.equals("exit"))
                break;
        }
        socket.close();
        System.out.println("发送完毕");
    }
}
