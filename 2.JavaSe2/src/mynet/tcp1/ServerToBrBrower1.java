package mynet.tcp1;

import java.io.*;
import java.net.*;

public class ServerToBrBrower1 {
    public static void main(String[] args) throws Exception {
        //面向BS架构，浏览器访问服务器，服务器返回HTML数据
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        Thread thread = new Thread(new ServerToBrowersThread(socket));
        thread.start();
    }
}

class ServerToBrowersThread implements Runnable {
    Socket socket;

    ServerToBrowersThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(socket.getOutputStream(), true, "UTF-8");

            // 构建HTML内容
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html>\n");
            htmlBuilder.append("<head>\n");
            htmlBuilder.append("<title>我是标题</title>\n");
            htmlBuilder.append("</head>\n");
            htmlBuilder.append("<body>\n");
            htmlBuilder.append("<h1 style=\"color:red;\">H1</h1>\n");
            htmlBuilder.append("<p style=\"color:blue;\">段落</p>\n");

            htmlBuilder.append("</body>\n");
            htmlBuilder.append("</html>\n");

            String htmlContent = htmlBuilder.toString();

            // 发送 HTTP 响应头
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html; charset=utf-8");
            ps.println("Content-Length: " + htmlContent.getBytes("UTF-8").length);
            ps.println(); // 空行分隔响应头和响应体

            // 发送 HTML 内容
            ps.print(htmlContent);
            ps.flush();

            System.out.println("发送完毕");
            System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
            System.out.println(socket.getInetAddress().getHostName());

            ps.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("客户端下线了");
            e.printStackTrace();
        }
    }

}
