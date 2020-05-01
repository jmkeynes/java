package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.JobInfoEntity;
import com.learn.pojo.PageRequest;
import com.learn.pojo.PageResultPojo;

import java.util.List;
import java.util.Map;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:08
 * 版本： 1.0
 */
public interface IJobInfoService extends IService<JobInfoEntity> {

    PageResultPojo<JobInfoEntity> getJobInfoPage(PageRequest request);

    List<Map<String,Object>> getCountSalaryLevel();
}
