package com.learn.shop.dto.pms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.learn.shop.entity.pms.ProductEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 14:25
 * @ClassName ProductDto
 */
@Setter
@Getter
public class ProductDto extends ProductEntity implements Serializable {

    @ApiModelProperty("商品规格")
    @TableField("sp_data")
    private String spData;

    @ApiModelProperty("专题商品关系表ID")
    private Long subjectId;

    @ApiModelProperty("优选专区和产品关系表ID")
    private Long prefrenceAreaId;
}
