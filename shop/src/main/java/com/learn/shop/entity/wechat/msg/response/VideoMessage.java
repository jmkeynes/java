package com.learn.shop.entity.wechat.msg.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/17
 */
@Setter
@Getter
public class VideoMessage extends BaseMessage{

    // 视频
    private Video Video;
}
