package com.csc.web.blog.domain.vo;

import com.csc.web.blog.domain.dto.SimpleUser;
import com.csc.web.blog.entity.Article;
import com.csc.web.blog.entity.Topic;
import lombok.Data;

import java.util.List;


@Data
public class TopicVo {
    private Topic topic;
    private List<Article> articles;
    private SimpleUser simpleUser;
    private List<SimpleUser> simpleUsers;
}