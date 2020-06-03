package com.learn.shop.controller.oms;


import com.learn.shop.entity.oms.OrderSettingEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.oms.IOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 订单设置表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "订单设置表 前端控制器")
@RestController
@RequestMapping("/oms-order-setting")
public class OrderSettingController {

    @Resource
    private IOrderSettingService orderSettingService;

    @ApiOperation("订单设置更新")
    @PostMapping("/updateOrderSetting")
    public ResultBean<Boolean> updateOrderSetting(OrderSettingEntity entity){
        return ResultBean.success(this.orderSettingService.updateById(entity));
    }

}

