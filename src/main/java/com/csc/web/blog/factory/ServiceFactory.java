package com.csc.web.blog.factory;

import com.csc.web.blog.service.ArticleService;
import com.csc.web.blog.service.TopicService;
import com.csc.web.blog.service.UserService;
import com.csc.web.blog.service.impl.ArticleServiceImpl;
import com.csc.web.blog.service.impl.TopicServiceImpl;
import com.csc.web.blog.service.impl.UserServiceImpl;


public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }

    public static ArticleService getArticleServiceInstance() {
        return new ArticleServiceImpl();
    }

    public static TopicService getTopicServiceInstance() {
        return new TopicServiceImpl();
    }

}