package com.atcjw.order.service.impl;

import com.atcjw.model.order.OrderInfo;
import com.atcjw.order.dao.OrderInfoMapper;
import com.atcjw.order.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
}
