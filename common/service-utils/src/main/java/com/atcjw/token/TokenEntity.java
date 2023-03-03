package com.atcjw.token;

import com.atcjw.exception.TokenException;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class TokenEntity {
    private Long userId;

    private String uuid;

    private Long time;

    public TokenEntity() {}

    public TokenEntity(String token) {
        String[] split = token.split(" ");
        if (split.length != 3) {
            throw new TokenException(20001, "错误格式的token");
        }
        try {
            this.userId = Long.parseLong(split[0]);
            this.uuid = split[1];
            this.time = Long.parseLong(split[2]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TokenException(200001, "token解析失败");
        }
    }

}
