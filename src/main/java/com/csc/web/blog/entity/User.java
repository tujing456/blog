package com.csc.web.blog.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class User {
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    //个人中心背景图
    private String banner;
    //邮箱
    private String email;
    //主页
    private String homepage;
    private Short follows;
    private Short fans;
    private Short articles;
    private LocalDateTime createTime;
    private Short status;
}