package org.JavaWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WORK3 {
    public static void main(String[] args) {
        // 数据库连接信息
        String url = "jdbc:mysql://localhost:3306/firstDB";
        String username = "root";
        String password = "qwert88SQL...";

        // SQL 查询语句
        String sql = "SELECT id, username, password, name, age FROM user WHERE age >= ? AND id <= ?";

        // 测试数据
        int testAge = 20;
        int testId = 4;

        // 使用 try-with-resources 自动关闭资源
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // 设置参数值
            preparedStatement.setInt(1, testAge); // age >= ?
            preparedStatement.setInt(2, testId);  // id <= ?

            // 执行查询
            ResultSet resultSet = preparedStatement.executeQuery();

            // 处理查询结果
            System.out.println("查询结果：");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.printf("ID: %d, Username: %s, Password: %s, Name: %s, Age: %d%n",
                        id, userName, pwd, name, age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
