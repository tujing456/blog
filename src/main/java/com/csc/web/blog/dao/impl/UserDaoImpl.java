package com.csc.web.blog.dao.impl;


import com.csc.web.blog.dao.UserDao;
import com.csc.web.blog.domain.vo.UserVo;
import com.csc.web.blog.entity.User;
import com.csc.web.blog.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDaoImpl implements UserDao {

    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }

    @Override
    public int[] batchInsert(List<User> userList) throws SQLException {
        //连接数据库
        Connection connection = DbUtil.getConnection();

        String sql = "INSERT INTO t_user (mobile,password,nickname,avatar,gender,birthday,introduction,create_time) VALUES (?,?,?,?,?,?,?,?) ";
        //关闭自动提交（true的时候即为自动提交）
        connection.setAutoCommit(false);
        //执行SQL语句
        PreparedStatement pstmt = connection.prepareStatement(sql);

        userList.forEach(user -> {
            try {
                pstmt.setString(1, user.getMobile());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getNickname());
                pstmt.setString(4, user.getAvatar());
                pstmt.setString(5, user.getGender());
                //日期的设置，可以使用setObject
                pstmt.setObject(6, user.getBirthday());
                pstmt.setString(7, user.getIntroduction());
                pstmt.setObject(8, user.getCreateTime());
                //addBatch将语句添加到同一批操作中
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //将添加进来的单个操作批量操作
        int[] result = pstmt.executeBatch();
        //提交数据，将数据存入数据库中的时候务必要有这句话
        connection.commit();
        //关闭数据库
        DbUtil.close(null, pstmt, connection);
        return result;
    }


    @Override
    public User findUserByMobile(String mobile) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mobile);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            //user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getShort("follows"));
            user.setFans(rs.getShort("fans"));
            user.setArticles(rs.getShort("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));

        }

        return user;
    }

    @Override
    public List<User> selectHotUsers() throws SQLException {
        return null;
    }

    @Override
    public List<User> selectPageUsers(int currentPage, int pageCount) throws SQLException {
        return null;
    }

    @Override
    public UserVo getUser(long id) throws SQLException {
        return null;
    }

    @Override
    public int getTotalUser() throws SQLException {
        return 0;
    }

}