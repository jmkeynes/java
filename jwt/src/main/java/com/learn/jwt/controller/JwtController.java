package com.learn.jwt.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.learn.jwt.dto.PayloadDto;
import com.learn.jwt.pojo.CommonResult;
import com.learn.jwt.service.IJwtTokenService;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者： jwp
 * 创建时间： 2020/7/26 14:47
 * 描述：JwtController
 * 添加根据HMAC算法生成和解析JWT令牌的接口，由于HMAC算法需要长度至少为32字节的的密钥，所以需要用MD5加密
 */
@Api(tags = "JWT令牌管理")
@RestController
@RequestMapping("token")
public class JwtController {

    @Resource
    private IJwtTokenService tokenService;

    @ApiOperation("使用对称加密（HMAC）算法生成token")
    @GetMapping("/hmac/generate")
    public CommonResult<String> generateTokenByHMAC() {
        PayloadDto payloadDto = tokenService.getDefaultPayloadDto();
        String token = tokenService.generateTokenByHMAC(JSONUtil.toJsonStr(payloadDto), SecureUtil.md5("test"));
        if (StringUtils.isNoneBlank(token)) {
            return CommonResult.success(token);
        }
        return CommonResult.failed();
    }

    @ApiOperation("使用对称加密（HMAC）算法验证token")
    @PostMapping("/hmac/verify")
    public CommonResult<PayloadDto> verifyTokenByHMAC(String token) {
        PayloadDto payloadDto = this.tokenService.verifyTokenByHMAC(token, SecureUtil.md5("test"));
        if (null == payloadDto) {
            return CommonResult.failed();
        }
        return CommonResult.success(payloadDto);
    }

    @ApiOperation("获取非对称加密（RSA）算法公钥")
    @GetMapping("/rsa/publicKey")
    public Object getRsaPublicKey() {
        RSAKey defaultRSAKey = this.tokenService.getDefaultRSAKey();
        return new JWKSet(defaultRSAKey).toJSONObject();
    }

    @ApiOperation("使用非对称加密（RSA）算法生成token")
    @GetMapping("/res/generate")
    public CommonResult<String> generateTokenByRSA() {
        PayloadDto defaultPayloadDto = this.tokenService.getDefaultPayloadDto();
        String token = this.tokenService.generateTokenByRsa(JSONUtil.toJsonStr(defaultPayloadDto), this.tokenService.getDefaultRSAKey());
        if (StringUtils.isNoneBlank(token)) {
            return CommonResult.success(token);
        }
        return CommonResult.failed();
    }

    @ApiOperation("使用非对称加密（RSA）算法验证token")
    @PostMapping("/rsa/verify")
    public CommonResult<PayloadDto> verifyTokenByRSA(String token) {
        PayloadDto payloadDto = this.tokenService.verifyTokenByRsa(token, this.tokenService.getDefaultRSAKey());
        if (null == payloadDto) {
            return CommonResult.failed();
        }
        return CommonResult.success(payloadDto);
    }
}
