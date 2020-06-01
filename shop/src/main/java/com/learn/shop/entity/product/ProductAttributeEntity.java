package com.learn.shop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 商品属性参数表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product_attribute")
public class ProductAttributeEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    @TableField("select_type")
    private Integer selectType;

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    @TableField("input_type")
    private Integer inputType;

    /**
     * 可选值列表，以逗号隔开
     */
    @TableField("input_list")
    private String inputList;

    /**
     * 排序字段：最高的可以单独上传图片
     */
    private Integer sort;

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    @TableField("filter_type")
    private Integer filterType;

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    @TableField("search_type")
    private Integer searchType;

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    @TableField("related_status")
    private Integer relatedStatus;

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    @TableField("hand_add_status")
    private Integer handAddStatus;

    /**
     * 属性的类型；0->规格；1->参数
     */
    private Integer type;


}
