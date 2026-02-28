package org.javaweb;

import org.javaweb.mapper.UserMapper1;
import org.javaweb.pojo.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest //SpringBoot单元测试的注解，测试时会启动这个SpringBoot项目，可以注入bean
class MybatisDemoApplicationTests1 {
    @Autowired
    private UserMapper1 userMapper;

    @BeforeAll
    public static void initUserTable(@Autowired JdbcTemplate jdbcTemplate) {
        // 清空表数据
        jdbcTemplate.execute("DELETE FROM user");

        // 插入初始数据
        String insertSql = """
                INSERT INTO user(id, username, password, name, age) VALUES 
                (1, 'daqiao', '123456', '大乔', 22),
                (2, 'xiaoqiao', '123456', '小乔', 18),
                (3, 'diaochan', '123456', '貂蝉', 24),
                (4, 'lvbu', '123456', '吕布', 28),
                (5, 'zhaoyun', '12345678', '赵云', 27);
                """;
        jdbcTemplate.execute(insertSql);
    }


    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testDeleteByUser() {
        User user = new User();
        user.setId(2);
        Integer result = userMapper.deleteByUser(user);
        System.out.println("删除成功:" + result);
    }

    @Test
    public void testInsertUser() {
        User user = new User(-1, "xiaoqiao", "123456", "小乔", 18);
        Integer result = userMapper.insertUser(user);
        System.out.println("插入成功:" + result);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1, "xiaoqiao", "123456", "小乔", 114);
        Integer result = userMapper.updateUser(user);
        System.out.println("更新成功:" + result);
    }

    @Test
    public void testFindById() {
        User user = userMapper.findById(4);
        System.out.println(user);
    }

    @Test
    public void testFindByDuringAge() {
        List<User> userList = userMapper.findByDuringAge(20, 25);
        userList.forEach(System.out::println);
    }
}