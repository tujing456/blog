package com.csc.web.blog.service;

import com.csc.web.blog.domain.dto.UserDto;
import com.csc.web.blog.factory.ServiceFactory;
import com.csc.web.blog.util.Result;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDao = new UserDto("13959082750", "111");
        Result result = userService.signIn(userDao);
        System.out.println("code:" + result.getCode() + "," + "msg:" + result.getMsg());
    }

    @Test
    public void getHotUsers() {
        Result result = userService.getHotUsers();
        System.out.println(result);
    }
}