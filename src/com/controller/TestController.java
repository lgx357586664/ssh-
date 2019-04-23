package com.controller;

import com.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LiGX
 * @Date: 2019-04-22 上午 10:44
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public User hello(){
        return new User("admin123","admin123");
    }
    @RequestMapping("/hehe")
    public User hehe(){
        return new User("admin456","admin456");
    }
}
