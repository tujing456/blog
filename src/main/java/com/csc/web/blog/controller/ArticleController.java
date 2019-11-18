package com.csc.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.csc.web.blog.factory.ServiceFactory;
import com.csc.web.blog.service.ArticleService;
import com.csc.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mq_xu
 * @ClassName ArticleController
 * @Description 文章控制器
 * @Date 2019/11/11
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/article/*"})
public class ArticleController extends HttpServlet {

    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private String getPatten(String uri) {
        int len = "/api/article".length();
        return uri.substring(len);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patten = getPatten(req.getRequestURI());
        switch (patten) {
            case "/hot":
                getHotArticles(req, resp);
                break;
            case "/list?page=*":
                getPageArticles(req, resp);
                break;
            case "/*":
                getArticle(req, resp);
                break;
        }
    }

    private void getHotArticles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new GsonBuilder().create();
        Result result = articleService.getHotArticles();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    private void getPageArticles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

    private void getArticle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}