package com.atcjw.order.service.impl;

import com.atcjw.model.order.PaymentInfo;
import com.atcjw.order.dao.PaymentInfoMapper;
import com.atcjw.order.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {
}
