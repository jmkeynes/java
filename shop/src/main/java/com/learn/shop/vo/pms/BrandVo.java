package com.learn.shop.vo.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 11:35
 * @ClassName BrandVo
 */
@Setter
@Getter
public class BrandVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("首字母")
    private String firstLetter;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @ApiModelProperty("是否显示")
    private Integer showStatus;

    @ApiModelProperty("产品数量")
    private Integer productCount;

    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;
}
