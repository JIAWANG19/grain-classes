package com.atcjw.activity.service.impl;

import com.atcjw.activity.dao.CouponInfoMapper;
import com.atcjw.activity.service.CouponInfoService;
import com.atcjw.activity.service.CouponUseService;
import com.atcjw.model.activity.CouponInfo;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService {
    @Autowired
    CouponInfoMapper couponInfoMapper;

    @Autowired
    CouponUseService couponUseService;

    @Override
    public Page<CouponInfo> pageQueryUsed(int pageNo, int pageSize, CouponUseQueryVo couponUseQueryVo) {
        return null;
    }
}
