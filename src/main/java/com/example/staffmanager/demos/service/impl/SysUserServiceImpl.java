package com.example.staffmanager.demos.service.impl;

import com.example.staffmanager.demos.entity.SysUser;
import com.example.staffmanager.demos.mapper.UserMapper;
import com.example.staffmanager.demos.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public SysUser selectUserById(long id) {
        return userMapper.selectUserById(id);
    }
}
