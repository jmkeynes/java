package com.learn.shop.vo.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 16:30
 * @ClassName CouponHistoryVo
 */
@Setter
@Getter
public class CouponInfoVo implements Serializable {


    @ApiModelProperty("优惠卷名称")
    private String name;

    @ApiModelProperty("优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券")
    private Integer type;

    @ApiModelProperty("使用类型：0->全场通用；1->指定分类；2->指定商品")
    private Integer useType;

    @ApiModelProperty("使用门槛；0表示无门槛")
    private BigDecimal minPoint;


    @ApiModelProperty("面值")
    private BigDecimal amount;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("开始有效期")
    private Date startTime;

    @ApiModelProperty("结束有效期")
    private Date endTime;

    @ApiModelProperty("总发行量")
    private Integer publishCount;

    @ApiModelProperty("已领取")
    private Integer receiveCount;

    @ApiModelProperty("待领取")
    private Integer toReceive;

    @ApiModelProperty("已使用")
    private Integer useCount;

    @ApiModelProperty("未使用")
    private Integer unusedCount;

}
