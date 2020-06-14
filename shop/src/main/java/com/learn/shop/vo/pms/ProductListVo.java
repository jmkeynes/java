package com.learn.shop.vo.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 7:04
 * @ClassName ProductListVo
 */
@Setter
@Getter
@ToString
@SolrDocument(collection = "solrhome")
public class ProductListVo implements Serializable {

    @Field("id")
    private Long id;

    @Field("pic")
    @ApiModelProperty(value = "图片")
    private String pic;

    @Field("name")
    @ApiModelProperty(value = "名称")
    private String name;

    @Field("brand_name")
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @Field("brand_id")
    @ApiModelProperty(value = "商品品牌ID")
    private Long brandId;

    @Field("product_sn")
    @ApiModelProperty(value = "产品编号")
    private String productSn;

    @Field("price")
    @ApiModelProperty(value = "价格")
    private String price;

    @Field("new_status")
    @ApiModelProperty(value = "数字 - 新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @Field("new_status_str")
    @ApiModelProperty(value = "字符串 - 新品状态:0->不是新品；1->新品")
    private String newStatusStr;

    @Field("publish_status")
    @ApiModelProperty(value = "数字 - 上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @Field("publish_status_str")
    @ApiModelProperty(value = "字符串 - 上架状态：0->下架；1->上架")
    private String publishStatusStr;

    @Field("recommand_status")
    @ApiModelProperty(value = "数字 - 推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    @Field("recommand_status_str")
    @ApiModelProperty(value = "字符串 - 推荐状态；0->不推荐；1->推荐")
    private String recommandStatusStr;

    @Field("sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Field("sale")
    @ApiModelProperty(value = "销量")
    private Integer sale;

    @Field("verify_status")
    @ApiModelProperty(value = "数字 - 审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;

    @Field("verify_status_str")
    @ApiModelProperty(value = "字符串 - 审核状态：0->未审核；1->审核通过")
    private String verifyStatusStr;

    @Field("product_category_id")
    @ApiModelProperty(value = "产品类型ID")
    private Long productCategoryId;

}

