package com.learn.redis.controller;

import com.learn.redis.pojo.Result;
import com.learn.redis.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author：江文谱
 * @date： 2020/5/5 20:24
 * @version： 1.0
 */
@RestController
@RequestMapping("sso")
@Api(tags = "UmsMemberController")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("getAuthCode")
    @ApiOperation("获取验证码")
    public Result getAuthCode(@RequestParam String telephone){
        return umsMemberService.getAuthCode(telephone);
    }

    @ApiOperation("修改密码")
    @PostMapping("updatePassword")
    public Result updatePassword(@RequestParam String telephone,@RequestParam String authCod){
        return umsMemberService.updatePassword(telephone,authCod);
    }

}
