package com.csc.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Topic {
    private Long id;
    //管理员id
    private Long adminId;
    private String name;
    private String logo;
    private String description;
    private Integer articles;
    private Integer follows;
    private LocalDateTime createTime;
}