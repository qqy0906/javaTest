package com.example.staffmanager.demos.web;

import com.example.staffmanager.demos.entity.AjaxResult;
import com.example.staffmanager.demos.entity.SysUser;
import com.example.staffmanager.demos.security.SysLoginService;
import com.example.staffmanager.demos.utils.Constants;
import com.example.staffmanager.demos.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    private SysLoginService loginService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser sysUser){
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(sysUser.getAccount(), sysUser.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", "admin");
        return ajax;
    }
}
