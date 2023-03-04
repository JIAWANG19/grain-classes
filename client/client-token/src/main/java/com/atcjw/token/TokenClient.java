package com.atcjw.token;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-token")
public interface TokenClient {

    @GetMapping("/admin/power/token/issue")
    String issuedToken(@RequestParam("userId") Long userId);

    @GetMapping("/admin/power/token/check")
    boolean checkToken(@RequestParam("token") String token);
}
