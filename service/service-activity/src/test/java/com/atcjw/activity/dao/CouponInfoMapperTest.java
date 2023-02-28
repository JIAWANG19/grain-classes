package com.atcjw.activity.dao;

import com.atcjw.model.activity.CouponInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CouponInfoMapperTest implements BaseMapperTest {
    @Autowired
    CouponInfoMapper couponInfoMapper;

    @Test
    public void testSelectList() {
        List<CouponInfo> couponInfos = couponInfoMapper.selectList(null);
        couponInfos.forEach(System.out::println);
    }
}
