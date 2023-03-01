package com.atcjw.order.controller;

import com.atcjw.model.order.OrderInfo;
import com.atcjw.order.service.OrderInfoService;
import com.atcjw.result.RetJson;
import com.atcjw.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/order/info")
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    @GetMapping("/{pageNo}/{pageSize}")
    public RetJson page(@PathVariable("pageNo") int pageNo,
                        @PathVariable("pageSize") int pageSize,
                        OrderInfoQueryVo infoQueryVo) {
        Page<OrderInfo> pageInfo = orderInfoService.pageInfo(pageNo, pageSize, infoQueryVo);
        return RetJson.ok().put("pageInfo", pageInfo);
    }
}
