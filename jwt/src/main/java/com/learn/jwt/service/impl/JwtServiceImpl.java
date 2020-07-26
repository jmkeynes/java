package com.learn.jwt.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.learn.jwt.dto.PayloadDto;
import com.learn.jwt.exception.JwtInvalidException;
import com.learn.jwt.service.IJwtTokenService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

/**
 * 作者：jwp
 * 创建时间： 2020/7/26 14:05
 * 描述：JwtServiceImpl
 */
@Service
public class JwtServiceImpl implements IJwtTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Override
    public String generateTokenByHMAC(String payloadStr, String secret) {

        //创建jws头部，设置签名和算法
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256)
                .type(JOSEObjectType.JWT)
                .build();
        //将负载信息封装到payload中
        Payload payload = new Payload(payloadStr);

        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {

            //创建MAC签名器
            JWSSigner signer = new MACSigner(secret);

            //获取签名
            jwsObject.sign(signer);
        } catch (Exception e) {
            LOGGER.error("\n失败信息：{}", e.getMessage());
            e.printStackTrace();
        }
        return jwsObject.serialize();
    }

    @Override
    public PayloadDto verifyTokenByHMAC(String token, String secret) {
        try {

            //解析token，获取jws对象
            JWSObject jwsObject = JWSObject.parse(token);

            //创建MAC验证器
            JWSVerifier verifier = new MACVerifier(secret);
            if (!jwsObject.verify(verifier)) {
                throw new JwtInvalidException("token签名不合法！！");
            }
            Payload payload = jwsObject.getPayload();
            PayloadDto payloadDto = JSONUtil.toBean(payload.toString(), PayloadDto.class);
            if (payloadDto.getExp() < System.currentTimeMillis()) {
                throw new JwtInvalidException("token签名已过期！！");
            }
            return payloadDto;
        } catch (Exception e) {
            LOGGER.error("\n失败信息：{}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PayloadDto getDefaultPayloadDto() {
        Date now = new Date();
        DateTime exp = DateUtil.offsetSecond(now, 3600);
        return PayloadDto.builder().sub("learn").iat(now.getTime())
                .exp(exp.getTime()).jti(UUID.randomUUID().toString()
                ).username("jwp").authorities(CollUtil.toList("ADMIN")).build();
    }

    @Override
    public RSAKey getDefaultRSAKey() {
        //从classpath下获取RSA密钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());

        //公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        //私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey).privateKey(privateKey).build();
    }

    @Override
    public String generateTokenByRsa(String payloadStr, RSAKey key) {
        //创建jws头部，设置签名算法和类型
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256).type(JOSEObjectType.JWT).build();

        //将负载信息封装到payload
        Payload payload = new Payload(payloadStr);

        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {

            //创建签名
            JWSSigner signer = new RSASSASigner(key, true);

            //签名信息
            jwsObject.sign(signer);

            //签名信息
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return jwsObject.serialize();
//        try {
//            创建签名
//            JWSSigner signer = new RSASSASigner(key, true);
//            JWSObject jwsObject = getJwsObject(payloadStr, signer);
//            return jwsObject.serialize();
//        } catch (JOSEException e) {
//            e.printStackTrace();
//            return null;
//        }
    }

    private JWSObject getJwsObject(String payloadStr, JWSSigner signer) {

        //创建jws头部，设置签名算法和类型
        JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256).type(JOSEObjectType.JWT).build();

        //将负载信息封装到payload
        Payload payload = new Payload(payloadStr);

        //创建JWS对象
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        try {
            jwsObject.sign(signer);

            //创建签名
//            JWSSigner signer = new RSASSASigner(key, true);

            //签名信息
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return jwsObject;
    }

    @Override
    public PayloadDto verifyTokenByRsa(String token, RSAKey key) {
        //从token中解析JWS对象
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            RSAKey publicRsaKey = key.toPublicJWK();
            JWSVerifier jwsVerifier = new RSASSAVerifier(publicRsaKey);
            //使用RSA公钥创建RSA验证器
            if (!jwsObject.verify(jwsVerifier)) {
                throw new JwtInvalidException("token签名不合法！");
            }
            String payload = jwsObject.getPayload().toString();
            PayloadDto payloadDto = JSONUtil.toBean(payload, PayloadDto.class);
            if (payloadDto.getExp() < new Date().getTime()) {
                throw new JwtInvalidException("token已过期！");
            }
            return payloadDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
