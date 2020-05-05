package com.learn.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author：江文谱
 * @date： 2020/5/4 23:02
 * @version： 1.0
 */
@Setter
@Getter
@TableName("pms_product")
public class PmsProduct implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "brand_id")
    private Long brandId;

    @TableField(value = "product_category_id")
    private Long productCategoryId;

    @TableField(value = "feight_template_id")
    private Long feightTemplateId;

    @TableField(value = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    @TableField(value = "product_sn")
    @ApiModelProperty(value = "货号")
    private String productSn;

    @TableField(value = "delete_status")
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @TableField(value = "publish_status")
    @ApiModelProperty(value = "上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @TableField(value = "new_status")
    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @TableField(value = "recommand_status")
    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    @TableField(value = "verify_status")
    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "销量")
    private Integer sale;

    private BigDecimal price;

    @TableField(value = "promotion_price")
    @ApiModelProperty(value = "促销价格")
    private BigDecimal promotionPrice;

    @TableField(value = "gift_growth")
    @ApiModelProperty(value = "赠送的成长值")
    private Integer giftGrowth;

    @TableField(value = "gift_point")
    @ApiModelProperty(value = "赠送的积分")
    private Integer giftPoint;

    @TableField(value = "use_point_limit")
    @ApiModelProperty(value = "限制使用的积分数")
    private Integer usePointLimit;

    @TableField(value = "sub_title")
    @ApiModelProperty(value = "副标题")
    private String subTitle;

    @TableField(value = "original_price")
    @ApiModelProperty(value = "市场价")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @TableField(value = "low_stock")
    @ApiModelProperty(value = "库存预警值")
    private Integer lowStock;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "商品重量，默认为克")
    private BigDecimal weight;

    @TableField(value = "preview_status")
    @ApiModelProperty(value = "是否为预告商品：0->不是；1->是")
    private Integer previewStatus;

    @TableField(value = "service_ids")
    @ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;

    private String keywords;

    private String note;

    @TableField(value = "album_pics")
    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @TableField(value = "detail_title")
    private String detailTitle;

    @TableField(value = "promotion_start_time")
    @ApiModelProperty(value = "促销开始时间")
    private Date promotionStartTime;

    @TableField(value = "promotion_end_time")
    @ApiModelProperty(value = "促销结束时间")
    private Date promotionEndTime;

    @TableField(value = "promotion_per_limit")
    @ApiModelProperty(value = "活动限购数量")
    private Integer promotionPerLimit;

    @TableField(value = "promotion_type")
    @ApiModelProperty(value = "促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
    private Integer promotionType;

    @TableField(value = "brand_name")
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @TableField(value = "product_category_name")
    @ApiModelProperty(value = "商品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "商品描述")
    private String description;

    @TableField(value = "detail_desc")
    private String detailDesc;

    @TableField(value = "detail_html")
    @ApiModelProperty(value = "产品详情网页内容")
    private String detailHtml;

    @TableField(value = "detail_mobile_html")
    @ApiModelProperty(value = "移动端网页详情")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;
}
