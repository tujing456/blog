package com.csc.web.blog.dao;

import com.csc.web.blog.entity.User;
import com.csc.web.blog.factory.DaoFactory;
import com.csc.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void batchInsert() throws SQLException {
        int[] result = userDao.batchInsert(JSoupSpider.getUsers());
        System.out.println(result);
    }

    @Test
    public void findUserByMobile() throws SQLException {
        User user = userDao.findUserByMobile("13951905171");
        System.out.println(user);
    }

    @Test
    public void selectAll() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void getTotalUser() throws SQLException {
        int result = userDao.getTotalUser();
        System.out.println(result);
    }
}