package com.learn.redis.service.impl;

import com.learn.redis.pojo.Result;
import com.learn.redis.service.RedisService;
import com.learn.redis.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author：江文谱
 * @date： 2020/5/5 20:39
 * @version： 1.0
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTHCODE;

    @Value("${redis.key.expire.authCode}")
    private long REDIS_KEY_EXPIRE_AUTHCODE;

    @Override
    public Result getAuthCode(String telephone) {
        String millis = new StringBuilder().append(System.currentTimeMillis()).toString();
        String code = millis.substring(millis.length() - 6);
        redisService.set(REDIS_KEY_PREFIX_AUTHCODE + telephone, code);
        redisService.expire(REDIS_KEY_PREFIX_AUTHCODE + telephone, REDIS_KEY_EXPIRE_AUTHCODE);
        return Result.success(code, "验证码获取成功");
    }

    @Override
    public Result updatePassword(String telephone, String authCod) {
        if (StringUtils.isEmpty(authCod)) {
            return Result.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTHCODE + telephone);
        if (authCod.equals(realAuthCode)) {
            return Result.success(null,"验证码校验成功");
        }
        return Result.failed("验证码校验失败");
    }
}
