package com.atcjw.user.service.impl;

import com.atcjw.model.user.User;
import com.atcjw.user.dao.UserMapper;
import com.atcjw.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryWithPassword(String email, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        wrapper.eq("password", password);
        return userMapper.selectOne(wrapper);
    }
}
