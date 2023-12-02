package com.example.staffmanager.demos.security;

import com.example.staffmanager.demos.entity.SysUser;
import com.example.staffmanager.demos.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserServiceImpl;
    @Autowired
    private SysPasswordService passwordService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserServiceImpl.getUserByName(username);
        passwordService.validate(user);
        return new LoginUser(user.getId(),user);
    }
}
