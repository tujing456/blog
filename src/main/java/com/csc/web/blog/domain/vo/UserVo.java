package com.csc.web.blog.domain.vo;

import com.csc.web.blog.domain.dto.SimpleUser;
import com.csc.web.blog.entity.Article;
import com.csc.web.blog.entity.User;
import lombok.Data;

import java.util.List;


@Data
public class UserVo {
    private User user;
    private List<Article> articles;
    private List<SimpleUser> simpleUsers;
}