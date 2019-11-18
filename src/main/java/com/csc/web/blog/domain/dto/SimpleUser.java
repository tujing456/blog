package com.csc.web.blog.domain.dto;

import lombok.Data;


@Data
public class SimpleUser {
    private Long id;
    private String nickname;
    private String avatar;
}