package com.atcjw.order.service;


import com.atcjw.model.order.OrderInfo;
import com.atcjw.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderInfoServiceTest implements BaseServiceTest{
    @Autowired
    OrderInfoService orderInfoService;

    @Test
    public void testPageInfo() {
        Page<OrderInfo> pageInfo = orderInfoService.pageInfo(0, 10, new OrderInfoQueryVo());
        System.out.println(pageInfo);
    }
}
