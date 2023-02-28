package com.atcjw.activity.service.impl;

import com.atcjw.activity.dao.CouponInfoMapper;
import com.atcjw.activity.service.CouponInfoService;
import com.atcjw.model.activity.CouponInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
}
