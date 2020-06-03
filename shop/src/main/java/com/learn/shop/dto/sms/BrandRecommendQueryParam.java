package com.learn.shop.dto.sms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 17:58
 * @ClassName BrandRecommendQueryParam
 */
@Setter
@Getter
public class BrandRecommendQueryParam extends PageRequest implements Serializable {

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("推荐状态")
    private Integer recommendStatus;
}
