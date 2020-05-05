package com.learn.oss.pojo.oss;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author：江文谱
 * @date： 2020/5/5 15:17
 * @version： 1.0
 * oss上传成功后的回调结果
 */
@Setter
@Getter
public class OssCallbackResult {

    @ApiModelProperty("文件名称")
    private String filename;

    @ApiModelProperty("文件大小")
    private String size;

    @ApiModelProperty("文件的mimeType")
    private String mimeType;

    @ApiModelProperty("图片文件的宽")
    private String width;

    @ApiModelProperty("图片文件的高")
    private String height;

}
