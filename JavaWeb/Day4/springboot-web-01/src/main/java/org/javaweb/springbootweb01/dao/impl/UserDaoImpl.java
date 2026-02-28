package org.javaweb.springbootweb01.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.javaweb.springbootweb01.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public List<String> getUserList() {
//        InputStream in = new FileInputStream("F:\\JavaWeb_Works\\Day4\\springboot-web-01\\src\\main\\resources\\user.txt");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        List<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
