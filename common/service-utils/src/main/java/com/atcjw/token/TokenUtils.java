package com.atcjw.token;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

public class TokenUtils {

    private static String encodeToken(String token) {
        byte[] bytes = token.getBytes(StandardCharsets.UTF_8);
        return Base64.encodeBase64String(bytes);
    }

    public static String decodeToken(String decodeToken) {
        byte[] bytes = Base64.decodeBase64(decodeToken);
        return StringUtils.newStringUtf8(bytes);
    }

    public static String newToken(Long userId) {
        StringBuilder sb = new StringBuilder();
        String uuid = UUID.randomUUID().toString();
        long time = new Date().getTime();
        String token = sb.append(userId).append(" ")
                .append(uuid).append(" ")
                .append(time).toString();
        return encodeToken(token);
    }
}
