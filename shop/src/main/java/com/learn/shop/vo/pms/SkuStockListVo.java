package com.learn.shop.vo.pms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 12:38
 * @ClassName SkuStockListVo
 */
@Setter
@Getter
public class SkuStockListVo implements Serializable {

    private Long id;

    @ApiModelProperty("SKU编号")
    private String skuCode;

    @ApiModelProperty("颜色，容量")
    private String spData;

    @ApiModelProperty("销售价格")
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty("商品库存")
    private Integer stock;

    @ApiModelProperty("库存预警")
    private Integer lowStock;
}
