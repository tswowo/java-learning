package org.javaweb.springbootweb01.Controller;

import jakarta.annotation.Resource;
import org.javaweb.springbootweb01.pojo.User;
import org.javaweb.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class UserController {
    //方式一：属性注入
//    @Autowired
//    private UserService userService;

    //方式二：构造器注入
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //方式三：方法参数注入
    private UserService userService;

//    @Autowired//Autowired(Sprint)和Resource(JavaEE)选一个就可以了
//    @Qualifier("userServiceImpl")
    @Resource(name = "userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        return userService.parseUserList();
    }
}
