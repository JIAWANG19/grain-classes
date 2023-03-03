package com.atcjw.user.service.impl;

import com.atcjw.model.user.UserInfo;
import com.atcjw.user.dao.UserInfoMapper;
import com.atcjw.user.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getByUserId(Long userId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return userInfoMapper.selectOne(wrapper);
    }
}
