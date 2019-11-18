package com.csc.web.blog.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mq_xu
 * @ClassName ArticleVo
 * @Description 文章视图类,从文章、专题、用户表联查出前端需要展示的数据
 * @Date 22:12 2019/11/11
 * @Version 1.0
 **/
@Data
public class ArticleVo  {
    private Long id;
    private Long userId;
    private Long topicId;
    private String nickname;
    private String avatar;
    private String name;
    private String logo;
    private String title;
    private String summary;
    private String thumbnail;
    private Integer likes;
    private Integer comments;
    private LocalDateTime createTime;
}