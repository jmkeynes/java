package com.learn.shop.vo.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 7:04
 * @ClassName ProductListVo
 */
@Setter
@Getter
@ToString
public class ProductListVo implements Serializable {

    private Long id;

    @ApiModelProperty(value = "图片")
    private String pic;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "产品编号")
    private String productSn;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "数字 - 新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(value = "字符串 - 新品状态:0->不是新品；1->新品")
    private String newStatusStr;

    @ApiModelProperty(value = "数字 - 上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(value = "字符串 - 上架状态：0->下架；1->上架")
    private String publishStatusStr;

    @ApiModelProperty(value = "数字 - 推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    @ApiModelProperty(value = "字符串 - 推荐状态；0->不推荐；1->推荐")
    private String recommandStatusStr;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    @ApiModelProperty(value = "数字 - 审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "字符串 - 审核状态：0->未审核；1->审核通过")
    private String verifyStatusStr;

}

