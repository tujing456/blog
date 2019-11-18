package com.csc.web.blog.factory;

import com.csc.web.blog.dao.ArticleDao;
import com.csc.web.blog.dao.TopicDao;
import com.csc.web.blog.dao.UserDao;
import com.csc.web.blog.dao.impl.ArticleDaoImpl;
import com.csc.web.blog.dao.impl.TopicDaoImpl;
import com.csc.web.blog.dao.impl.UserDaoImpl;


public class DaoFactory {

    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }

    public static ArticleDao getArticleDaoInstance() {
        return new ArticleDaoImpl();
    }

    public static TopicDao getTopicDaoInstance() {
        return new TopicDaoImpl();
    }

}