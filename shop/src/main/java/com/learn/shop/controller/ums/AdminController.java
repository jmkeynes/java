package com.learn.shop.controller.ums;


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
@Controller
@RequestMapping("/ums-admin")
public class AdminController {

    @GetMapping("/gotoBackground")
    public String gotoBackground(){
        return "background";
    }

    @GetMapping("gotoBackgroundHome")
    public String gotoBackgroundHome(){
        return "background_home";
    }

}

