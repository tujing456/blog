package com.csc.web.blog.domain.dto;

import lombok.Data;


@Data
public class UserDto {
    private String mobile;
    private String password;

    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto() {
    }
}