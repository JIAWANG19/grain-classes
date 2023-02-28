package com.atcjw.user.dao;

import com.atcjw.model.user.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoMapperTest implements BaseMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void testSelectList() {
        List<UserInfo> userInfos = userInfoMapper.selectList(null);
        userInfos.forEach(System.out::println);
    }

}
