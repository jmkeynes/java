package com.learn.shop.entity.pms;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 产品分类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_category")
public class ProductCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上机分类的编号：0表示一级分类
     */
    @ApiModelProperty("编号，顶级父类默认为0")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    /**
     * 分类级别：0->1级；1->2级
     */
    @ApiModelProperty("分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty("商品数量")
    @TableField("product_count")
    private Integer productCount;

    @ApiModelProperty("数量单位")
    @TableField("product_unit")
    private String productUnit;

    /**
     * 是否显示在导航栏：0->不显示；1->显示
     */
    @ApiModelProperty("是否显示在导航栏：0->不显示；1->显示")
    @TableField("nav_status")
    private Integer navStatus;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @ApiModelProperty("显示状态：0->不显示；1->显示")
    @TableField("show_status")
    private Integer showStatus;

    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 图标
     */
    private String icon;

    private String keywords;

    /**
     * 描述
     */
    private String description;

    @TableLogic
    @TableField("delete_status")
    private Integer deleteStatus;


}
