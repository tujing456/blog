package com.csc.web.blog.service;

import com.csc.web.blog.domain.dto.UserDto;
import com.csc.web.blog.util.Result;


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