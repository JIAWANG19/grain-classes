package com.atcjw.order.service.impl;

import com.atcjw.model.order.OrderDetail;
import com.atcjw.model.order.OrderInfo;
import com.atcjw.order.dao.OrderInfoMapper;
import com.atcjw.order.service.OrderDetailService;
import com.atcjw.order.service.OrderInfoService;
import com.atcjw.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    OrderDetailService orderDetailService;

    @Override
    public Page<OrderInfo> pageInfo(int pageNo, int pageSize, OrderInfoQueryVo infoQueryVo) {
        QueryWrapper<OrderInfo> wrapper;
        if (infoQueryVo != null) {
            wrapper = new QueryWrapper<>();
            Long userId = infoQueryVo.getUserId();
            String outTradeNo = infoQueryVo.getOutTradeNo();
            String phone = infoQueryVo.getPhone();
            String timeEnd = infoQueryVo.getCreateTimeEnd();
            String timeBegin = infoQueryVo.getCreateTimeBegin();
            Integer orderStatus = infoQueryVo.getOrderStatus();

            // 分页条件查询数据封装
            if (userId != null) {
                wrapper.eq("user_id", userId);
            }
            if (StringUtils.hasLength(outTradeNo)) {
                wrapper.eq("out_trade_no", outTradeNo);
            }
            if (StringUtils.hasLength(phone)) {
                wrapper.eq("phone", phone);
            }
            if (orderStatus != null) {
                wrapper.eq("order_status", orderStatus);
            }
            if (StringUtils.hasLength(timeBegin)) {
                wrapper.ge("create_time", timeBegin);
            }
            if (StringUtils.hasLength(timeEnd)) {
                wrapper.le("create_time", timeEnd);
            }
        } else {
            wrapper = null;
        }
        Page<OrderInfo> pageInfo = new Page<>(pageNo, pageSize);
        orderInfoMapper.selectPage(pageInfo, wrapper);

        pageInfo.getRecords().forEach(orderInfo -> {
            Long id = orderInfo.getId();
            OrderDetail orderDetail = orderDetailService.getById(id);
            if (orderDetail != null) {
                orderInfo.getParam().put("courseName", orderDetail.getCourseName());
            }
        });
        return pageInfo;
    }
}
