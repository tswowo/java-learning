package org.javaweb.mapper;

import org.apache.ibatis.annotations.*;
import org.javaweb.pojo.User;

import java.util.List;

@Mapper//应用程序运行时，自动创建一个实现类(代理对象)，并且自动将该实现类注入到spring容器中
public interface UserMapper1 {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(Integer id);

    @Delete("DELETE FROM user WHERE id=#{id}")
    Integer deleteByUser(User user);

    @Insert("INSERT INTO user(username,password,name,age) VALUES(#{username},#{password},#{name},#{age})")
    Integer insertUser(User user);

    @Update("UPDATE user SET username=#{username},password=#{password},name=#{name},age=#{age} WHERE id=#{id}")
    Integer updateUser(User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findById(@Param("id") Integer theId);

    @Select("SELECT id,name,password,name,age FROM user WHERE age>=#{start} AND age <=#{end}")
    List<User> findByDuringAge(@Param("start") Integer start, @Param("end") Integer end);
}
