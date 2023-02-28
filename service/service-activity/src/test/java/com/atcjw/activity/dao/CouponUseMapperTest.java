package com.atcjw.activity.dao;

import com.atcjw.model.activity.CouponUse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CouponUseMapperTest implements BaseMapperTest{
    @Autowired
    CouponUseMapper couponUseMapper;

    @Test
    public void testSelectList() {
        List<CouponUse> couponInfos = couponUseMapper.selectList(null);
        couponInfos.forEach(System.out::println);
    }
}
