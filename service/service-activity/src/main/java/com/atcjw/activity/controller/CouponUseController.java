package com.atcjw.activity.controller;

import com.atcjw.activity.service.CouponUseService;
import com.atcjw.model.activity.CouponUse;
import com.atcjw.result.RetJson;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/activity/couponUse")
public class CouponUseController {
    @Autowired
    CouponUseService couponUseService;

    /**
     * 分页查询已经使用的优惠卷
     */
    @GetMapping("/{pageNo}/{pageSize}")
    public RetJson pageQueryUsed(@PathVariable("pageNo") int pageNo,
                                 @PathVariable("pageSize") int pageSize,
                                 CouponUseQueryVo couponUseQueryVo) {
        Page<CouponUse> pageInfo = couponUseService.pageQueryUsed(pageNo, pageSize, couponUseQueryVo);
        return RetJson.ok().put("pageInfo", pageInfo);
    }
}
