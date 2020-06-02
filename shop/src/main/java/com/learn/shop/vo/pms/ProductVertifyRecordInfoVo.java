package com.learn.shop.vo.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 13:32
 * @ClassName ProductVertifyRecordInfoVo
 */
@Setter
@Getter
public class ProductVertifyRecordInfoVo implements Serializable {

    private Long id;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("审核结果")
    private Integer status;

    @ApiModelProperty("反馈详情")
    private String detail;

    @ApiModelProperty("审核人员")
    private String vertifyMan;
}
