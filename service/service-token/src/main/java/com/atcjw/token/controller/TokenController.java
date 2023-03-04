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
            stringRedisTemplate.opsForSet().add(TOKEN_KEY, token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("token 签发失败. userId: {}", userId);
            return null;
        }
    }

    @GetMapping("/check")
    public boolean checkToken(@RequestParam("token") String token) {
        boolean isSuccess = Boolean.TRUE.equals(stringRedisTemplate.opsForSet().isMember(TOKEN_KEY, token));
        if (isSuccess) {
            log.info("token验证成功, token: {}", token);
            return true;
        } else {
            log.info("token验证失败, token: {}", token);
            return false;
        }
    }
}
