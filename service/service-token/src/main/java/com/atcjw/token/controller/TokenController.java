package com.atcjw.token.controller;

import com.atcjw.token.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/admin/power/token")
public class TokenController {
    private final static String TOKEN_KEY = "token";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/issue")
    public String issuedToken(@RequestParam("userId") Long userId) {
        String token = TokenUtils.newToken(userId);
        try {
            stringRedisTemplate.opsForHash().put(TOKEN_KEY, token, String.valueOf(userId));
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("token 签发失败. userId: {}", userId);
            return null;
        }
    }

    @GetMapping("/userId")
    public Long getUserId(@RequestParam("token") String token) {
        String userIdStr = (String) stringRedisTemplate.opsForHash().get(TOKEN_KEY, token);
        if (userIdStr != null) {
            Long userId = Long.parseLong(userIdStr);
            log.info("token验证成功, userId: {}", userId);
            return userId;
        } else {
            log.info("token验证失败");
            return null;
        }
    }

    @GetMapping("/check")
    public boolean checkToken(@RequestParam("token") String token) {
        return stringRedisTemplate.opsForHash().hasKey(TOKEN_KEY, token);
    }
}
