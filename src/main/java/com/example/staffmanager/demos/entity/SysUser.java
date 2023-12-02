package com.example.staffmanager.demos.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String account;
    private String password;
    private String name;
}
