package gui1.EventListenerTest;

import javax.swing.*;

public class EventTest2 {
    public static void main(String[] args) {
        //第二种：提供匿名内部类
        JFrame frame = new JFrame("第二种事件写法");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("登录");
        button.addActionListener(e -> System.out.println("登录"));
        panel.add(button);

        frame.setVisible(true);
    }
}
