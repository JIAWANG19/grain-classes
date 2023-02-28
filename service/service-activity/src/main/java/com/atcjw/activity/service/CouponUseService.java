package com.atcjw.activity.service;

import com.atcjw.model.activity.CouponUse;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CouponUseService extends IService<CouponUse> {
    Page<CouponUse> pageQueryUsed(int pageNo, int pageSize, CouponUseQueryVo couponUseQueryVo);
}
