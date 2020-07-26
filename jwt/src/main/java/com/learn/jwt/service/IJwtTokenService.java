package com.learn.jwt.service;

import com.learn.jwt.dto.PayloadDto;
import com.nimbusds.jose.jwk.RSAKey;


/**
 * 作者： jwp
 * 创建时间： 2020/7/26 13:57
 * 描述：IJwtService
 */
public interface IJwtTokenService {

    /**
     * 使用对称加密（HMAC）算法生成token
     *
     * @param payloadStr str
     * @param secret     盐值
     * @return token
     */
    String generateTokenByHMAC(String payloadStr, String secret);

    /**
     * 使用对称加密（HMAC）算法验证token
     *
     * @param token  token
     * @param secret 盐值
     * @return token信息存储类
     */
    PayloadDto verifyTokenByHMAC(String token, String secret);

    /**
     * 设置默认的Payload的方法，JWT过期默认60min
     *
     * @return payload
     */
    PayloadDto getDefaultPayloadDto();

    /**
     * 从类路径下读取证数文件并转换成RSAKey对象
     *
     * @return RASKey
     */
    RSAKey getDefaultRSAKey();

    /**
     * 使用RSA算法生成token
     *
     * @param payloadStr str
     * @param key        rsaKey
     * @return token
     */
    String generateTokenByRsa(String payloadStr, RSAKey key);

    /**
     * 使用RSA算法校验token
     *
     * @param token token
     * @param key   rsaKey
     * @return token存储对象
     */
    PayloadDto verifyTokenByRsa(String token, RSAKey key);
}
