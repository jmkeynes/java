package com.learn.shop.dto.sms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 14:04
 * @ClassName CouponQueryParam
 */
@Setter
@Getter
public class CouponQueryParam extends PageRequest implements Serializable {

    @ApiModelProperty("优惠卷名称")
    private String name;

    @ApiModelProperty("优惠卷类型")
    private Integer type;
}
