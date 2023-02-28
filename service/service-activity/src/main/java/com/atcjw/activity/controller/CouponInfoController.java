package com.atcjw.activity.controller;

import com.atcjw.activity.service.CouponInfoService;
import com.atcjw.model.activity.CouponInfo;
import com.atcjw.model.activity.CouponUse;
import com.atcjw.result.RetJson;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/activity/couponInfo")
public class CouponInfoController {
    @Autowired
    CouponInfoService couponInfoService;

    @GetMapping("/{pageNo}/{pageSize}")
    public RetJson page(@PathVariable("pageNo") int pageNo,
                        @PathVariable("pageSize") int pageSize) {
        Page<CouponInfo> pageInfo = couponInfoService.page(new Page<>(pageNo, pageSize));
        return RetJson.ok().put("pageInfo", pageInfo);
    }

    @GetMapping("/{id}")
    public RetJson getById(@PathVariable("id") Long id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        return RetJson.ok().put("couponInfo", couponInfo);
    }

    @PostMapping("")
    public RetJson insert(@RequestBody CouponInfo couponInfo) {
        boolean success = couponInfoService.save(couponInfo);
        if (success) {
            return RetJson.ok();
        } else {
            return RetJson.fail("添加失败");
        }
    }

    @PutMapping("")
    public RetJson update(@RequestBody CouponInfo couponInfo) {
        boolean success = couponInfoService.updateById(couponInfo);
        if (success) {
            return RetJson.ok();
        } else {
            return RetJson.fail("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public RetJson deleteById(@PathVariable("id") Long id) {
        boolean success = couponInfoService.removeById(id);
        if (success) {
            return RetJson.ok();
        } else {
            return RetJson.fail("删除失败");
        }
    }

    @DeleteMapping("")
    public RetJson deleteByIdList(@RequestBody List<Long> ids) {
        boolean success = couponInfoService.removeBatchByIds(ids);
        if (success) {
            return RetJson.ok();
        } else {
            return RetJson.fail("批量删除失败");
        }
    }
}
