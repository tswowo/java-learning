package gui1.LayoutTest;

import javax.swing.*;

public class BoxLayoutTest1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame("盒子布局管理器BoxLayout");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.add(new JButton("按钮1"));
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JButton("按钮2"));
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JButton("按钮3"));
        panel.add(Box.createVerticalStrut(20));

        frame.setVisible(true);
    }
}
