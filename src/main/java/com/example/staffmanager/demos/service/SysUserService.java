package com.example.staffmanager.demos.service;

import com.example.staffmanager.demos.entity.SysUser;

public interface SysUserService {
    SysUser getUserByName(String username);

    SysUser selectUserById(long id);
}
