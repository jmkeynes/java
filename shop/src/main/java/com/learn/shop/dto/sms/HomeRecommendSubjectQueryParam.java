package com.learn.shop.dto.sms;

import com.learn.shop.pojo.request.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/3 19:37
 * @ClassName HomeRecommendSubjectQueryVo
 */
@Setter
@Getter
public class HomeRecommendSubjectQueryParam extends PageRequest implements Serializable {

    @ApiModelProperty("专题名称")
    private String subjectName;

    @ApiModelProperty("推荐状态")
    private Integer recommendStatus;
}
