package gui1.EventListenerTest;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyLIstenerTest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("按键事件监听器KeyAdapter");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        //按键事件监听器
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER)
                    System.out.println("按下了回车");
                else if (keyCode == KeyEvent.VK_SPACE)
                    System.out.println("按下了空格");
            }
        });

        frame.setVisible(true);
        //让窗口成为焦点
        frame.requestFocus();
    }
}
