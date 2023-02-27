package com.atcjw.vod.service;

import com.atcjw.model.order.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceTest implements BaseServiceTest{
    @Autowired
    OrderDetailService orderDetailService;

    @Test
    public void testList() {
        List<OrderDetail> list = orderDetailService.list();
        list.forEach(System.out::println);
    }
}
