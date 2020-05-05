package com.learn.oss.controller.oss;

import com.learn.oss.pojo.pojo.Result;
import com.learn.oss.service.oss.IOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：江文谱
 * @date： 2020/5/5 16:07
 * @version： 1.0
 */
@RestController
@Api(tags = "OSS管理")
@RequestMapping("/oss")
public class OSSConroller {

    @Autowired
    private IOssService ossService;

    @GetMapping("policy")
    @ApiOperation(value = "oss上传签名生成")
    public Result policy() {
        return Result.success(this.ossService.policy());
    }

    @ApiOperation(value = "oss上传成功回调")
    @PostMapping("callback")
    public Result callback(HttpServletRequest request) {
        return Result.success(this.callback(request));
    }
}
