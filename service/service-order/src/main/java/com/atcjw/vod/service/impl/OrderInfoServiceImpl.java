package com.atcjw.vod.service.impl;

import com.atcjw.model.order.OrderInfo;
import com.atcjw.vod.dao.OrderInfoMapper;
import com.atcjw.vod.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
}
