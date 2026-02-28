package org.JavaWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WORK2 {
    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/firstDB"; // 替换为你的数据库地址
        String username = "root"; // 替换为你的数据库用户名
        String password = "qwert88SQL..."; // 替换为你的数据库密码

        // SQL 更新语句
        String sql = "UPDATE user SET password = ?, name = ?, age = ? WHERE id = ?";

        // 测试参数
        String newPassword = "666888";
        String newName = "关羽";
        int newAge = 32;
        int userId = 4;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // 设置参数值
            preparedStatement.setString(1, newPassword); // password
            preparedStatement.setString(2, newName);     // name
            preparedStatement.setInt(3, newAge);         // age
            preparedStatement.setInt(4, userId);         // id

            // 执行更新
            int rowsAffected = preparedStatement.executeUpdate();

            // 输出结果
            System.out.println("受影响的行数: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
