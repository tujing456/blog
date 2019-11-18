package com.csc.web.blog.controller;

import com.csc.web.blog.service.TopicService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.csc.web.blog.factory.ServiceFactory;
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
 * @ClassName TopicController
 * @Description 专题控制器
 * @Date 2019/11/16
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/topic/*"})
public class TopicController extends HttpServlet {
    private TopicService topicService = ServiceFactory.getTopicServiceInstance();
    private static Logger logger = LoggerFactory.getLogger(TopicController.class);

    private String getPatten(String uri) {
        int len = "/api/topic".length();
        return uri.substring(len);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patten = getPatten(req.getRequestURI());
        switch (patten) {
            case "/hot":
                getHotTopics(req, resp);
                break;
            case "/list?page=*":
                getPageTopics(req, resp);
                break;
            case "/*":
                getTopic(req, resp);
                break;
        }
    }

    private void getHotTopics(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        Result result = topicService.getHotTopics();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    private void getPageTopics(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void getTopic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}