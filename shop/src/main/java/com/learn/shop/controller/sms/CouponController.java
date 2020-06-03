package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.CouponQueryParam;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.ICouponService;
import com.learn.shop.vo.sms.CouponInfoVo;
import com.learn.shop.vo.sms.CouponVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 优惠卷表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "优惠卷表 前端控制器")
@RestController
@RequestMapping("/sms-coupon-entity")
public class CouponController {

    @Resource
    private ICouponService couponService;

    /**
     * 优惠卷列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @ApiOperation("优惠卷列表，分页查询")
    @PostMapping("/getPageCouponList")
    public ResultBean<IPage<CouponVo>> getPageCouponList(CouponQueryParam param) {
        return this.couponService.getPageCouponList(param);
    }

    /**
     * 修改优惠卷
     *
     * @param entity 优惠卷实例
     * @author jwp
     * @date 2020-6-3
     */
    @ApiOperation("修改优惠卷")
    @PostMapping("/updateCoupon")
    public ResultBean<Boolean> updateCoupon(CouponEntity entity) {
        return ResultBean.success(this.couponService.updateById(entity));
    }

    /**
     * 优惠卷详情
     *
     * @param id 优惠卷id
     * @author jwp
     * @date 2020-6-3
     */
    @ApiOperation("根据id查询优惠卷领取详情")
    @PostMapping("/getCouponById")
    public ResultBean<CouponInfoVo> getCouponById(Long id) {
        return this.couponService.getCouponById(id);
    }

}

