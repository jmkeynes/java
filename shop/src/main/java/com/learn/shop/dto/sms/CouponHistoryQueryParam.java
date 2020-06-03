package com.learn.shop.dto.sms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 15:49
 * @ClassName CouponHistoryQueryParam
 */
@Setter
@Getter
public class CouponHistoryQueryParam  extends PageRequest implements Serializable {

    @ApiModelProperty("使用状态")
    private Integer useStatus;

    @ApiModelProperty("订单编号")
    private String orderId;
}
