package gui1.EventListenerTest;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ActionListenTest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("点击事件监听器ActionListener");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        JButton button = new JButton("点击");
        //点击事件监听器
        button.addActionListener(event->{
            System.out.println("点击了");
            JOptionPane.showMessageDialog(frame, "登陆了");
        });

        panel.add(button);


        frame.setVisible(true);
    }
}
