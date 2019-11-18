package com.csc.web.blog.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;


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