package gui1.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame("边界布局管理器BorderLayout");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(new JButton("按钮东"),BorderLayout.EAST);
        panel.add(new JButton("按钮西"),BorderLayout.WEST);
        panel.add(new JButton("按钮南"),BorderLayout.SOUTH);
        panel.add(new JButton("按钮北"),BorderLayout.NORTH);
        panel.add(new JButton("按钮中"),BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
