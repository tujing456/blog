package com.csc.web.blog.service;

import com.csc.web.blog.util.Result;


public interface ArticleService {
    /**
     * 获取热门文章
     *
     * @return
     */
    Result getHotArticles();

    /**
     * 获取分页文章
     *
     * @return
     */
    Result getPageArticles(int currentPage, int pageCount);

    /**
     * 获取文章详情
     *
     * @return
     */
    Result getArticle(long id);
}