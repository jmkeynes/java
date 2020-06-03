package com.learn.shop.vo.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 20:14
 * @ClassName AdvertiseListVo
 */
@Setter
@Getter
public class AdvertiseListVo implements Serializable {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("广告名称")
    private String name;

    @ApiModelProperty("轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    @ApiModelProperty("图片")
    private String pic;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("上下线状态：0->下线；1->上线")
    private Integer status;

    @ApiModelProperty("点击数")
    private Integer clickCount;

    @ApiModelProperty("下单数")
    private Integer orderCount;
}
