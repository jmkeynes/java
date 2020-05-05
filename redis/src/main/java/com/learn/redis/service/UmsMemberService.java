package com.learn.redis.service;

import com.learn.redis.pojo.Result;

/**
 * @author：江文谱
 * @date： 2020/5/5 20:37
 * @version： 1.0
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone 电话毫秒
     */
    Result getAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone 手机号
     * @param authCod 验证码
     */
    Result updatePassword(String telephone, String authCod);
}
