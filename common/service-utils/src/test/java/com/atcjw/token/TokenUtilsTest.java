package com.atcjw.token;

import org.junit.jupiter.api.Test;

public class TokenUtilsTest {
    @Test
    public void testCode() {
        String text = "hello world! 你好世界";
        System.out.println("编码前:" + text);
//        String encodeToken = TokenUtils.encodeToken(text);
//        System.out.println("编码后:" + encodeToken);
//        String decodeToken = TokenUtils.decodeToken(encodeToken);
//        System.out.println("解码后:" + decodeToken);
//        assert text.equals(decodeToken);
    }

    @Test
    public void testNewToken() {
        long userId = 123123123L;
        System.out.println("userId: " + userId);
        String token = TokenUtils.newToken(userId);
        System.out.println("获取到的token: " + token);
//        String encodeToken = TokenUtils.encodeToken(token);
//        System.out.println("编码后的token:" + encodeToken);
//        String decodeToken = TokenUtils.decodeToken(encodeToken);
//        System.out.println("解码后的token:" + decodeToken);
//        assert token.equals(decodeToken);
    }
}
