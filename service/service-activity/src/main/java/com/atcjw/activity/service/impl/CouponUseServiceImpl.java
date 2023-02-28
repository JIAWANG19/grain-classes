package com.atcjw.activity.service.impl;

import com.atcjw.activity.dao.CouponUseMapper;
import com.atcjw.activity.service.CouponUseService;
import com.atcjw.client.UserInfoFeignClient;
import com.atcjw.model.activity.CouponUse;
import com.atcjw.model.user.UserInfo;
import com.atcjw.vo.activity.CouponUseQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CouponUseServiceImpl extends ServiceImpl<CouponUseMapper, CouponUse>  implements CouponUseService {
    @Autowired
    CouponUseMapper couponUseMapper;

    @Autowired
    UserInfoFeignClient userInfoFeignClient;

    @Override
    public Page<CouponUse> pageQueryUsed(int pageNo, int pageSize, CouponUseQueryVo queryVo) {
        Page<CouponUse> pageInfo = new Page<>(pageNo, pageSize);
        if (queryVo != null) {
            Long couponId = queryVo.getCouponId();
            String couponStatus = queryVo.getCouponStatus();
            String getTimeBegin = queryVo.getGetTimeBegin();
            String getTimeEnd = queryVo.getGetTimeEnd();
            // 封装条件
            QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();
            if (couponId != null) {
                wrapper.eq("coupon_id", couponId);
            }
            if (StringUtils.hasLength(couponStatus)) {
                wrapper.eq("coupon_status", couponStatus);
            }
            if (StringUtils.hasLength(getTimeBegin)) {
                wrapper.ge("get_time", getTimeBegin);
            }
            if (StringUtils.hasLength(getTimeEnd)) {
                wrapper.le("get_time", getTimeEnd);
            }
            couponUseMapper.selectPage(pageInfo, wrapper);
        } else {
            couponUseMapper.selectPage(pageInfo, null);
        }
        pageInfo.getRecords().forEach(item -> {
            UserInfo userInfo = userInfoFeignClient.getById(item.getUserId());
            if (userInfo != null) {
                item.getParam().put("nickName", userInfo.getNickName());
                item.getParam().put("phone", userInfo.getPhone());
            }
        });
        return pageInfo;
    }
}
