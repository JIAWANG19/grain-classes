package com.atcjw.order.service.impl;

import com.atcjw.model.order.OrderDetail;
import com.atcjw.order.dao.OrderDetailMapper;
import com.atcjw.order.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
