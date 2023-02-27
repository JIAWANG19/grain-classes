package com.atcjw.order.controller;

import com.atcjw.result.RetJson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/vod/user")
//@CrossOrigin // 跨域
public class UserController {
    @PostMapping("/login")
    public RetJson login() {
        return RetJson.ok().put("token", "admin-token");
    }

    @GetMapping("/info")
    public RetJson info() {
        return RetJson.ok().put("roles", "admin")
                .put("introduction", "I am a super administrator")
                .put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .put("name", "Super Admin");
    }
}