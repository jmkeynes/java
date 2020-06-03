package com.learn.shop.entity.oms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_cart_item")
public class CartItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("product_id")
    private Long productId;

    @TableField("product_sku_id")
    private Long productSkuId;

    @TableField("member_id")
    private Long memberId;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 添加到购物车的价格
     */
    private BigDecimal price;

    /**
     * 商品主图
     */
    @TableField("product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    @TableField("product_sub_title")
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    @TableField("product_sku_code")
    private String productSkuCode;

    /**
     * 会员昵称
     */
    @TableField("member_nickname")
    private String memberNickname;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @TableField("modify_date")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @TableField("delete_status")
    private Integer deleteStatus;

    /**
     * 商品分类
     */
    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("product_brand")
    private String productBrand;

    @TableField("product_sn")
    private String productSn;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @TableField("product_attr")
    private String productAttr;


}
