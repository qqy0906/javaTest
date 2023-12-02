package com.example.staffmanager.demos.mapper;

import com.example.staffmanager.demos.entity.SysUser;

public interface UserMapper {
    SysUser getUserByName(String account);

    SysUser selectUserById(long id);
}
