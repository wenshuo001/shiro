package com.example.shiro.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String dbSource;
    private String phone;
    private String password;
    private String email;
    private String perms;

}