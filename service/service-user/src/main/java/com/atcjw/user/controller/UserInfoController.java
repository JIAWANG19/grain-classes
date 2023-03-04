package com.atcjw.user.controller;

import com.atcjw.model.user.UserInfo;
import com.atcjw.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/{id}")
    public UserInfo getById(@PathVariable("id") Long id) {
        return userInfoService.getById(id);
    }
}
