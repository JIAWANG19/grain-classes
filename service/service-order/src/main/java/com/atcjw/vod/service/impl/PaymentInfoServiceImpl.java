package com.atcjw.vod.service.impl;

import com.atcjw.model.order.PaymentInfo;
import com.atcjw.vod.dao.PaymentInfoMapper;
import com.atcjw.vod.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {
}
