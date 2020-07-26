package com.learn.jwt.exception;

/**
 * 作者： jwp
 * 创建时间： 2020/7/26 14:26
 * 描述：JwtInvalidException
 */
public class JwtInvalidException extends RuntimeException {

    public JwtInvalidException(String message) {
        super(message);
    }
}
