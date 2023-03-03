package com.atcjw.user.service;

import com.atcjw.model.user.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    User queryWithPassword(String email, String password);
}
