package imgview1;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageViewer {
    public static void main(String[] args){
        // 在事件调度线程中创建和显示GUI
        SwingUtilities.invokeLater(() -> {
            // 创建主窗口
            JFrame frame = new JFrame("简单图片查看器");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            // 让窗口居中显示
            frame.setLocationRelativeTo(null);
            // 创建标签以显示图片
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            // 创建滚动面板，方便查看大图
            JScrollPane scrollPane = new JScrollPane(label);
            // 将滚动面板添加到窗口（这行是关键，否则组件不会显示）
            frame.add(scrollPane);
            // 加载并显示图片
            String imagePath = "resources/114.jpg";
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                ImageIcon icon = new ImageIcon(imagePath);
                // 调整图片大小以适应窗口，保持比例
                Image image = icon.getImage().getScaledInstance(
                        700, -1, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
            } else {
                label.setText("无法找到图片文件: " + imagePath);
                // 设置提示文字的字体大小
                label.setFont(new Font("宋体", Font.PLAIN, 16));
            }
            // 显示窗口
            frame.setVisible(true);
        });
    }
}
