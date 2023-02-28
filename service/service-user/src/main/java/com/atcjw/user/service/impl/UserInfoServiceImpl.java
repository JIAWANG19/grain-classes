package com.atcjw.user.service.impl;

import com.atcjw.model.user.UserInfo;
import com.atcjw.user.dao.UserInfoMapper;
import com.atcjw.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
