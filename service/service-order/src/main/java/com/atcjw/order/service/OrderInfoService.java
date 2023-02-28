package com.atcjw.order.service;

import com.atcjw.model.order.OrderInfo;
import com.atcjw.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderInfoService extends IService<OrderInfo> {
    // 条件分页查询
    Page<OrderInfo> pageInfo(int pageNo, int pageSize, OrderInfoQueryVo infoQueryVo);
}
