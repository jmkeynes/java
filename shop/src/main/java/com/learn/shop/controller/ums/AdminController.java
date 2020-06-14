package com.learn.shop.controller.ums;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "后台用户表 前端控制器")
@Controller
@RequestMapping("/ums-admin")
public class AdminController {

    @ApiOperation("后台首页路由")
    @GetMapping("/gotoBackground")
    public String gotoBackground(){
        return "background";
    }

    @ApiOperation("后台首页路由Home")
    @GetMapping("gotoBackgroundHome")
    public String gotoBackgroundHome(){
        return "background_home";
    }

}

