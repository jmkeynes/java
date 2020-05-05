package com.learn.oss.service.oss;

import com.learn.oss.pojo.oss.OssCallbackResult;
import com.learn.oss.pojo.oss.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：江文谱
 * @date： 2020/5/5 15:19
 * @version： 1.0
 * oss上传service
 */
public interface IOssService {

    /**
     * oss上传策略
     * @return
     */
    OssPolicyResult policy();

    /**
     * oss上传回调成功
     * @param request
     * @return
     */
    OssCallbackResult callback(HttpServletRequest request);
}
