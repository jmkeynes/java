package com.learn.oss.dto.oss;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author：江文谱
 * @date： 2020/5/5 15:15
 * @version： 1.0
 * oss上传成功后的回调参数
 */
@Getter
@Setter
public class OssCallbackParam {

    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;

    @ApiModelProperty("回调是传入request中的参数")
    private String callbackBody;

    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;
}
