package com.atcjw.client;

import com.atcjw.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-user")
public interface UserInfoFeignClient {
    @GetMapping("/admin/user/userInfo/{id}")
    UserInfo getById(@PathVariable("id") Long id);
}
