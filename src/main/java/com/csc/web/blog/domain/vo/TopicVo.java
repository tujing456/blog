package com.csc.web.blog.domain.vo;

import com.csc.web.blog.domain.dto.SimpleUser;
import com.csc.web.blog.entity.Article;
import com.csc.web.blog.entity.Topic;
import lombok.Data;

import java.util.List;

/**
 * @author mq_xu
 * @ClassName TopicVo
 * @Description 专题视图类, 包含专题自身信息、专题下所有文章、创建者信息(简略)、关注者信息(简略)
 * @Date 2019/11/16
 * @Version 1.0
 **/
@Data
public class TopicVo {
    private Topic topic;
    private List<Article> articles;
    private SimpleUser simpleUser;
    private List<SimpleUser> simpleUsers;
}