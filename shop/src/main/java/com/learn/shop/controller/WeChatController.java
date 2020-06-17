package com.learn.shop.controller;

import com.learn.shop.service.IWeChatService;
import com.learn.shop.util.SHA;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.TreeSet;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/16 9:49
 * @ClassName WeChatController  花生壳内网穿透隐射路径会失败
 */
@RequestMapping("/weChat")
@RestController
@Api(tags = "微信公众号")
public class WeChatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatController.class);

    @Value("${weChat.token}")
    private String token;

    @Resource
    private IWeChatService chatService;

    /**
     * 处理微信服务器发来的请求，进行签名验证
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @param echostr   验证字符串
     * @date 2020-6-16
     * @author jwp
     */
    @ApiOperation("处理微信服务器发来的请求，进行签名验证")
    @GetMapping(value = "validate")
    public String validate(@RequestParam(value = "signature") String signature,
                           @RequestParam(value = "timestamp") String timestamp,
                           @RequestParam(value = "nonce") String nonce,
                           @RequestParam(value = "echostr") String echostr) {

        //将token，timestamp，nonce字典排序
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add(token);
        treeSet.add(timestamp);
        treeSet.add(nonce);

        //将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder builder = new StringBuilder();
        treeSet.forEach(builder::append);
        String encode = SHA.encode(builder.toString());

        //前面正确返回随机的字符串
        return signature.equals(encode) ? echostr : null;
    }

    /**
     * 此处处理微信服务器发来的消息
     *
     * @param request 请求体
     * @date 2020-6-16
     * @author jwp
     */
    @ApiOperation("处理微信服务器发来的消息")
    @PostMapping(value = "validate")
    public String validate(HttpServletRequest request) {
        return this.chatService.processRequest(request);
    }

}
