package com.learn.shop.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 22:37
 * @ClassName PageRequest
 */
@Setter
@Getter
@ApiModel("分页请求参数")
public class PageRequest {

    @ApiModelProperty(value = "当前页")
    private int page = 0;

    @ApiModelProperty(value = "分页偏移量")
    private int limit = 10;

}
