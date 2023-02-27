package com.atcjw.order.dao;

import com.atcjw.model.order.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailMapperTest implements BaseMapperTest{
    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Test
    public void testSelectList() {
        List<OrderDetail> infos = orderDetailMapper.selectList(null);
        infos.forEach(System.out::println);
    }
}
