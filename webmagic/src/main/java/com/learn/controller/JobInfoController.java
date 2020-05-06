package com.learn.controller;

import com.learn.pojo.PageRequest;
import com.learn.service.IJobInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 创建人：江文谱
 * 创建时间： 2020/5/1 11:21
 * 版本： 1.0
 */
@Controller
@Api(tags = "job信息")
@RequestMapping("job")
public class JobInfoController extends BaseController {


    @Autowired
    private IJobInfoService jobInfoService;

    @ApiOperation(value = "页面路由  页面跳转")
    @GetMapping("goToJobInfoPage")
    public String goToJobInfoPage() {
        return "job_info_list";
    }


    @GetMapping("getJobInfoPage")
    @ResponseBody
    @ApiOperation(value = "获取职位信息分页列表")
    public Map<String, Object> getJobInfoPage(PageRequest request) {
        return this.resultGoToLayuiFormat(jobInfoService.getJobInfoPage(request));
    }

    @ApiOperation(value = "统计职位中薪资的情况")
    @GetMapping("getCountSalaryLevel")
    @ResponseBody
    public List<Map<String, Object>> getCountSalaryLevel() {
        return this.jobInfoService.getCountSalaryLevel();
    }
}
