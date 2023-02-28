package com.atcjw.activity.service;

import com.atcjw.model.activity.CouponInfo;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CouponInfoService extends IService<CouponInfo> {
    Page<CouponInfo> pageQueryUsed(int pageNo, int pageSize, CouponUseQueryVo couponUseQueryVo);
}
