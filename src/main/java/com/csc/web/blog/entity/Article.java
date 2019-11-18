package com.csc.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Article {
    private Long id;
    private Long userId;
    private String title;
    private String summary;
    private String thumbnail;
    private String content;
    private Integer likes;
    private Integer comments;
    private LocalDateTime createTime;

}