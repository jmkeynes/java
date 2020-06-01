package com.learn.shop.entity.pms;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品信息
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_product")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("brand_id")
    private Long brandId;

    @TableField("product_category_id")
    private Long productCategoryId;

    @TableField("feight_template_id")
    private Long feightTemplateId;

    @TableField("product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    /**
     * 货号
     */
    @TableField("product_sn")
    private String productSn;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @TableField("delete_status")
    private Integer deleteStatus;

    /**
     * 上架状态：0->下架；1->上架
     */
    @TableField("publish_status")
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    @TableField("new_status")
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    @TableField("recommand_status")
    private Integer recommandStatus;

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    @TableField("verify_status")
    private Integer verifyStatus;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 销量
     */
    private Integer sale;

    private BigDecimal price;

    /**
     * 促销价格
     */
    @TableField("promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 赠送的成长值
     */
    @TableField("gift_growth")
    private Integer giftGrowth;

    /**
     * 赠送的积分
     */
    @TableField("gift_point")
    private Integer giftPoint;

    /**
     * 限制使用的积分数
     */
    @TableField("use_point_limit")
    private Integer usePointLimit;

    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 市场价
     */
    @TableField("original_price")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 库存预警值
     */
    @TableField("low_stock")
    private Integer lowStock;

    /**
     * 单位
     */
    private String unit;

    /**
     * 商品重量，默认为克
     */
    private BigDecimal weight;

    /**
     * 是否为预告商品：0->不是；1->是
     */
    @TableField("preview_status")
    private Integer previewStatus;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    @TableField("service_ids")
    private String serviceIds;

    private String keywords;

    private String note;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    @TableField("album_pics")
    private String albumPics;

    @TableField("detail_title")
    private String detailTitle;

    @TableField("detail_desc")
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    @TableField("detail_html")
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    @TableField("detail_mobile_html")
    private String detailMobileHtml;

    /**
     * 促销开始时间
     */
    @TableField("promotion_start_time")
    private LocalDateTime promotionStartTime;

    /**
     * 促销结束时间
     */
    @TableField("promotion_end_time")
    private LocalDateTime promotionEndTime;

    /**
     * 活动限购数量
     */
    @TableField("promotion_per_limit")
    private Integer promotionPerLimit;

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    @TableField("promotion_type")
    private Integer promotionType;

    /**
     * 品牌名称
     */
    @TableField("brand_name")
    private String brandName;

    /**
     * 商品分类名称
     */
    @TableField("product_category_name")
    private String productCategoryName;


}
