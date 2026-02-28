package org.javaweb.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper2 {
    List<User> findAll();

    void deleteById(Integer id);

    Integer deleteByUser(User user);

    Integer insertUser(User user);

    Integer updateUser(User user);

    User findById(@Param("id") Integer theId);

    List<User> findByDuringAge(@Param("start") Integer start, @Param("end") Integer end);
}