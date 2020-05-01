package com.learn.controller;

import com.learn.pojo.PageRequest;
import com.learn.service.IJobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("job")
public class JobInfoController extends BaseController {


    @Autowired
    private IJobInfoService jobInfoService;

    @RequestMapping("goToJobInfoPage")
    public String goToJobInfoPage(){
        return "job_info_list";
    }



    @RequestMapping("getJobInfoPage")
    @ResponseBody
    public Map<String,Object> getJobInfoPage(PageRequest request){
        return this.resultGoToLayuiFormat(jobInfoService.getJobInfoPage(request));
    }

    @RequestMapping("getCountSalaryLevel")
    @ResponseBody
    public List<Map<String,Object>> getCountSalaryLevel(){
        return this.jobInfoService.getCountSalaryLevel();
    }
}
