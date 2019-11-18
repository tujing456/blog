package com.csc.web.blog.service.impl;

import com.csc.web.blog.dao.TopicDao;
import com.csc.web.blog.domain.vo.TopicVo;
import com.csc.web.blog.entity.Topic;
import com.csc.web.blog.factory.DaoFactory;
import com.csc.web.blog.service.TopicService;
import com.csc.web.blog.util.Result;
import com.csc.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    @Override
    public Result getHotTopics() {
        List<Topic> topicList = null;
        try {
            topicList = topicDao.selectHotTopics();
        } catch (SQLException e) {
            logger.error("获取热门专题出现异常");
        }
        if (topicList != null) {
            return Result.success(topicList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getPageTopics(int currentPage, int pageCount) {
        return null;
    }

    @Override
    public Result getTopic(long id) {
        TopicVo topicVo = null;
        try {
            topicVo = topicDao.getTopic(id);
        } catch (SQLException e) {
            logger.error("根据id获取用户详情出现异常");
        }
        if (topicVo != null) {
            return Result.success(topicVo);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}