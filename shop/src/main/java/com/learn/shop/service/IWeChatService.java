package com.learn.shop.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/16
 */
public interface IWeChatService {

    /**
     * 核心服务类接收解析请求体并处理请求
     *
     * @param request 请求体
     * @return 结果
     * @author jwp
     * @date 2020-6-16
     */
    String processRequest(HttpServletRequest request);
}
