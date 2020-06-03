package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.CouponHistoryQueryParam;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.ICouponHistoryService;
import com.learn.shop.vo.sms.CouponHistoryListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 优惠券使用、领取历史表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "优惠券使用、领取历史表 前端控制器")
@RestController
@RequestMapping("/sms-coupon-history-entity")
public class CouponHistoryController {

    @Resource
    private ICouponHistoryService couponHistoryService;

    /**
     * 优惠卷领取使用历史
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @ApiOperation("领取历史表查询分页")
    @PostMapping("/getPageCouponHistoryList")
    public ResultBean<IPage<CouponHistoryListVo>> getPageCouponHistoryList(CouponHistoryQueryParam param) {
        return this.couponHistoryService.getPageCouponHistoryList(param);
    }

}

