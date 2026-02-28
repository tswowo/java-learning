import org.JavaWeb.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest1 {
    @Test
    public void testUpdate() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接
        String url = "jdbc:mysql://localhost:3306/firstDB";
        String user = "root";
        String password = "qwert88SQL...";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //执行SQL
        int i = statement.executeUpdate("UPDATE user SET age =25 WHERE id =1");
        System.out.println("SQL执行影响的记录数为：" + i);
        //释放资源
        statement.close();
        connection.close();
    }


    @Test
    public void testQuery() throws Exception {
        String url = "jdbc:mysql://localhost:3306/firstDB";
        String user = "root";
        String password = "qwert88SQL...";
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);

            stmt = connection.prepareStatement("SELECT * FROM user WHERE username =? AND password=?");
            stmt.setString(1, "%");
            stmt.setString(2, "123456");

            rs = stmt.executeQuery();

            while (rs.next()) {
                org.JavaWeb.User userInfo = new org.JavaWeb.User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 按相反顺序关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}