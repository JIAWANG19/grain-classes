//package com.atcjw.vod.interceptor;
//
//import com.atcjw.token.TokenClient;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Slf4j
//public class ServiceVodInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    TokenClient tokenClient;
//
//    /**
//     * 会拦截所有的非 GET 并且请求头中不包含 token 的方法
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        String path = request.getRequestURI();
//        String method = request.getMethod();
//        if (!method.equalsIgnoreCase("get")) {
//            String token = request.getHeader("token");
//            if (!StringUtils.hasLength(token) || !tokenClient.checkToken(token)) {
//                log.info("{}({}) 该请求被拦截, 没有携带token或token不正确", path, method);
//                return false;
//            }
//            return true;
//        }
//        return true;
//    }
//}
