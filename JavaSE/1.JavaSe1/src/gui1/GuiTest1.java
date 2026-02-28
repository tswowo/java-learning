package gui1;

import javax.swing.*;

public class GuiTest1 {
    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("登录窗口");
        loginFrame.setSize(800, 600);  // 设置窗口大小
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(300, 400, 100, 50);
        panel.add(loginButton);
        panel.setVisible(true);

        loginFrame.setVisible(true);  // 设置窗口可见
    }
}
