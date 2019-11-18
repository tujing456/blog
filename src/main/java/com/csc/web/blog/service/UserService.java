package com.csc.web.blog.service;

import com.csc.web.blog.domain.dto.UserDto;
import com.csc.web.blog.util.Result;

/**
 * @author mq_xu
 * @ClassName UserService
 * @Description 用户业务逻辑接口
 * @Date 12:01 2019/11/9
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 用户登录功能
     *
     * @param userDto
     * @return
     */
    Result signIn(UserDto userDto);

    /**
     * 获取热门用户信息
     * @return
     */
    Result getHotUsers();

    /**
     * 获取分页用户信息
     * @return
     */
    Result getPageUsers();

    /**
     * 根据id查询用户详情数据
     * @param id
     * @return
     */
    Result getUser(long id);
}