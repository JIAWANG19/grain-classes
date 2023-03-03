package com.atcjw.interceptor;

import com.atcjw.annotation.PowerRequire;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

@Slf4j
public class UserPowerInterceptor implements HandlerInterceptor {

    /**
     * 会拦截所有的非 GET 并且请求头中不包含 token 的方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // todo 对用户权限的鉴权
        String path = request.getRequestURI();
        String method = request.getMethod();
        if (!method.equalsIgnoreCase("get")) {
            String token = null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
            // todo 去redis中查询是否存在该token
            if (StringUtils.hasLength(token)) {
                return true;
            }
            log.info("{}({}) 该请求被拦截, 原因: 没有携带token", path, method);
            return false;
        }
        return true;
    }
}
