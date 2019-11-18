package com.csc.web.blog.service.impl;

import com.csc.web.blog.dao.UserDao;
import com.csc.web.blog.domain.dto.UserDto;
import com.csc.web.blog.domain.vo.UserVo;
import com.csc.web.blog.entity.User;
import com.csc.web.blog.factory.DaoFactory;
import com.csc.web.blog.service.UserService;
import com.csc.web.blog.util.Result;
import com.csc.web.blog.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName UserServiceImpl
 * @Description 用户业务逻辑接口实现类
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result signIn(UserDto userDto) {
        User user = null;
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (user != null) {
            //数据库查到的用户密码和前端传递的用户密码（经过加密）相等
            if (user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) {
                //登录成功
                return Result.success(user);
            } else {
                //密码错误
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            //账号错误
            return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }
    }


    @Override
    public Result getHotUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectHotUsers();
        } catch (SQLException e) {
            logger.error("获取热门用户出现异常");
        }
        if (userList != null) {
            //成功并返回数据
            return Result.success(userList);
        }
        //失败，不返回数据
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getPageUsers() {
        return null;
    }

    @Override
    public Result getUser(long id) {
        UserVo userVo = null;
        try {
            userVo = userDao.getUser(id);
        } catch (SQLException e) {
            logger.error("根据id获取用户详情出现异常");
        }
        if (userVo != null) {
            return Result.success(userVo);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}
