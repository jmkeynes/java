package com.learn.shop.dto.sms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 20:04
 * @ClassName HomeAdvertiseQueryParam
 */
@Setter
@Getter
public class HomeAdvertiseQueryParam extends PageRequest implements Serializable {

    @ApiModelProperty("广告名称")
    private String name;

    @ApiModelProperty("轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    @ApiModelProperty("到期时间")
    private String endTime;
}
