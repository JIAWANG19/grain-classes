package com.atcjw.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atcjw.user.dao")
public class UserConfig {
}
