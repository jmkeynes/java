package com.learn.shop.vo.oms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 21:08
 * @ClassName OrderPageListVo
 */
@Setter
@Getter
public class OrderListVo implements Serializable {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("提交时间")
    private Date createTime;

    @ApiModelProperty("用户账号")
    private String memberUsername;

    @ApiModelProperty("订单金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("支付方式")
    private Integer payType;

    @ApiModelProperty("订单来源")
    private Integer sourceType;

    @ApiModelProperty("订单状态")
    private Integer status;

}
