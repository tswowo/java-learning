package gui1.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame("网格布局管理器GridLayout");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3,2));
        panel.add(new JButton("按钮1"));
        panel.add(new JButton("按钮2"));
        panel.add(new JButton("按钮3"));
        panel.add(new JButton("按钮4"));
        panel.add(new JButton("按钮5"));
        panel.add(new JButton("按钮6"));

        frame.setVisible(true);
    }
}
