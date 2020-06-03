package com.learn.shop.dto.oms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 20:55
 * @ClassName OrderQueryParam
 */
@Setter
@Getter
public class OrderQueryParam  extends PageRequest implements Serializable {

    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("收货人/手机号码")
    private String memberOrPhone;

    @ApiModelProperty("提交时间   时间格式：2018-09-13 16:57:40")
    private String createTime;

    @ApiModelProperty("订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    @ApiModelProperty("订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;

    @ApiModelProperty("订单来源：0->PC订单；1->app订单")
    private Integer sourceType;
}
