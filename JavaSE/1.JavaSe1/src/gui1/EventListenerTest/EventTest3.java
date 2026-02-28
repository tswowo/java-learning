package gui1.EventListenerTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest3 {
    public static void main(String[] args) {
        //第三种，也就是最重要的，自定义窗口
        //我们现在做一个自定义登录窗口，界面对象本身也是事件监听器对象
        LoginFrame lf = new LoginFrame("登陆界面");

        lf.setVisible(true);
    }
}

class LoginFrame extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("登录");
    }

    public LoginFrame(String title) {
        this.setTitle(title);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        JButton button = new JButton("登录");
        // 注册事件监听器
//        button.addActionListener(e-> System.out.println("登录"));
        button.addActionListener(this);
        JPanel panel = new JPanel();
        this.add(panel);
        panel.add(button);
    }
}
