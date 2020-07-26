package com.learn.jwt.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 作者： jwp
 * 创建时间： 2020/7/26 13:59
 * 描述：PlayDao
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "用于封装JWT中存储的信息")
public class PayloadDto {

    @ApiModelProperty(value = "主题", position = 1)
    private String sub;

    @ApiModelProperty(value = "签发时间", position = 2)
    private Long iat;

    @ApiModelProperty(value = "过期时间", position = 3)
    private Long exp;

    @ApiModelProperty(value = "JWT的ID", position = 4)
    private String jti;

    @ApiModelProperty(value = "用户名称", position = 5)
    private String username;

    @ApiModelProperty(value = "用户拥有的权限", position = 6)
    private List<String> authorities;
}
