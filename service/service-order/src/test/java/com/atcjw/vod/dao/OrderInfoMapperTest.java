package com.atcjw.vod.dao;

import com.atcjw.model.order.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderInfoMapperTest implements BaseMapperTest {
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Test
    public void testSelectList() {
        List<OrderInfo> infos = orderInfoMapper.selectList(null);
        infos.forEach(System.out::println);
    }
}
