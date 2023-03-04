package com.atcjw.user.controller;

import com.atcjw.model.user.User;
import com.atcjw.model.user.UserInfo;
import com.atcjw.result.RetJson;
import com.atcjw.token.TokenClient;
import com.atcjw.user.service.UserInfoService;
import com.atcjw.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("admin/user/power")
public class UserPowerController {
    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    TokenClient tokenClient;

    @PostMapping("/login")
    public RetJson login(@RequestParam("email") String email,
                         @RequestParam("password") String password) {
        if (!(StringUtils.hasLength(email) && StringUtils.hasLength(password))) {
            return RetJson.fail("登录失败");
        }
        User user = userService.queryWithPassword(email, password);
        if (user == null) {
            return RetJson.fail("邮箱或密码错误");
        }
        String token = tokenClient.issuedToken(user.getId());
        return RetJson.ok().put("token", token);
    }

    @GetMapping("/info")
    public RetJson info(@RequestParam("token") String token) {
        try {
            Long userId = tokenClient.getUserId(token);
            if (userId == null) {
                return RetJson.fail("身份验证失败");
            }
            User user = userService.getById(userId);
            if (user != null) {
                UserInfo userInfo = userInfoService.getByUserId(user.getId());
                return RetJson.ok().put("userInfo", userInfo);
            } else {
                return RetJson.fail("用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RetJson.fail("用户不存在");
        }
//
//
//        return RetJson.ok().put("roles", "admin")
//                .put("introduction", "I am a super administrator")
//                .put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
//                .put("name", "Super Admin");
    }
}