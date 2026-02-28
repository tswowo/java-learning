package gui1.EventListenerTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest1 {
    public static void main(String[] args) {
        //第一种：提供实现类，创建对象，并注册监听器
        JFrame frame = new JFrame("第一种事件写法");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("登录");
        button.addActionListener(new myActionListener());
        panel.add(button);

        frame.setVisible(true);
    }
}

class myActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("登录");
    }
}
