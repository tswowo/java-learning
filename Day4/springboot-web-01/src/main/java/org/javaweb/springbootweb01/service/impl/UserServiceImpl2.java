package org.javaweb.springbootweb01.service.impl;

import org.javaweb.springbootweb01.dao.UserDao;
import org.javaweb.springbootweb01.pojo.User;
import org.javaweb.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
//@Primary//相同类型bean的选择
public class UserServiceImpl2 implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> parseUserList() {
        List<String> lines = userDao.getUserList();
        List<User> userList = lines.stream().map(line -> {
            return new User(1, "用户名", "密码", "姓名", -1, LocalDateTime.now());
        }).toList();
        return userList;
    }
}
