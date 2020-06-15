package com.learn.shop.dto.pms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 8:29
 * @ClassName ProductQueryParam
 */
@Setter
@Getter
public class ProductQueryParam extends PageRequest {

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品货号")
    private String productSn;

    @ApiModelProperty(value = "产品类型ID")
    private Long productCategoryId;

    @ApiModelProperty(value = "商品品牌ID")
    private String brandId;

    @ApiModelProperty(value = "上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;


}
