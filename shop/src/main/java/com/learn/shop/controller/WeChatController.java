package com.learn.shop.controller;

import com.learn.shop.util.SHA;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.TreeSet;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/16 9:49
 * @ClassName WeChatController
 */
@RequestMapping("/weChat")
@Controller
@Api(tags = "微信公众号")
public class WeChatController {

    @Value("weChat.token")
    private String token;

    @GetMapping("/validate")
    @ResponseBody
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
        if (signature.equals(encode)) {
            return echostr;
        } else {
            return null;
        }

    }

//    @PatchMapping("/validate")
//    public String validate(@RequestParam(value = "signature") String signature,
//                           @RequestParam(value = "timestamp") String timestamp,
//                           @RequestParam(value = "nonce") String nonce,
//                           @RequestParam(value = "echostr") String echostr){
//
//    }

}
