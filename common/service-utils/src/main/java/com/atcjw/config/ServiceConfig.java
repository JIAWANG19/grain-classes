package com.atcjw.config;

import com.atcjw.interceptor.ServiceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServiceConfig implements WebMvcConfigurer {

    @Bean
    public ServiceInterceptor getServiceInterceptor() {
        return new ServiceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getServiceInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/login")
                .excludePathPatterns("logon")
                .excludePathPatterns("/admin/vod/file**");
    }
}
