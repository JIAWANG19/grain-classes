package com.atcjw.config;


import com.atcjw.interceptor.UserPowerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserPowerConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new UserPowerInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/login")
                .excludePathPatterns("logon");
    }
}
