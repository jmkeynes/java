package com.learn.shop.vo.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 15:54
 * @ClassName CouponListVo
 */
@Setter
@Getter
public class CouponHistoryListVo implements Serializable {

    @ApiModelProperty("优惠码")
    private String couponCode;

    @ApiModelProperty("领取人昵称")
    private String memberNickname;

    @ApiModelProperty("领取方式：0->后台赠送；1->主动获取")
    private Integer getType;

    @ApiModelProperty("领取人ID")
    private Long memberId;

    @ApiModelProperty("领取时间")
    private Date createTime;

    @ApiModelProperty("当前状态")
    private Integer useStatus;

    @ApiModelProperty("使用时间")
    private Date useTime;

    @ApiModelProperty("订单编号")
    private String orderSn;



}
