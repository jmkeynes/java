package com.learn.shop.controller.oms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.oms.OrderQueryParam;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.oms.IOrderService;
import com.learn.shop.vo.oms.OrderListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "订单表 前端控制器")
@RestController
@RequestMapping("/oms-order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @ApiOperation("订单查询分页列表")
    @PostMapping("/getPageOrderList")
    public ResultBean<IPage<OrderListVo>> getPageOrderList(OrderQueryParam param){
        return this.orderService.getPageOrderList(param);
    }

}

