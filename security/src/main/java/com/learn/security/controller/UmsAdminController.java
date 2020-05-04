package com.learn.security.controller;

import com.learn.security.dto.UmsAdminLoginParam;
import com.learn.security.entity.UmsAdmin;
import com.learn.security.entity.UmsPermission;
import com.learn.security.pojo.Result;
import com.learn.security.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：江文谱
 * @date： 2020/5/4 9:47
 * @version： 1.0
 */
@Controller
@RequestMapping("/admin")
@Api(tags = "UmsAdminController")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation(value = "用户注册")
    @PostMapping("/registry")
    @ResponseBody
    public Result registry(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin adminToken = adminService.register(umsAdminParam);
        if (StringUtils.isEmpty(adminToken)) {
            Result.failed();
        }
        return Result.success(adminToken);
    }

    @ApiOperation(value = "登陆以后返回token")
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (StringUtils.isEmpty(token)) {
            return Result.validateFailed("用户名或密码错误！！！");
        }
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success(tokenMap);
    }

    @GetMapping("/getPermissionList/{adminId}")
    @ApiOperation(value = "获取用户所有权限 包括+-权限")
    @ResponseBody
    public Result<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        return Result.success(adminService.getPermissionList(adminId));
    }
}
