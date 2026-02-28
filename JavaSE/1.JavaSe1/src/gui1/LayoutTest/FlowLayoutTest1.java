package gui1.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame("流式布局管理器FlowLayout");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel=new JPanel();
        frame.add( panel);
        panel.setLayout(new FlowLayout());
        panel.add(new JButton("按钮1"));
        panel.add(new JButton("按钮2"));
        panel.add(new JButton("按钮3"));

        frame.setVisible(true);
    }
}
