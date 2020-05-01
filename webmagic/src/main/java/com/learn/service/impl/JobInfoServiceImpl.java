package com.learn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.dao.JobInfoDao;
import com.learn.entity.JobInfoEntity;
import com.learn.entity.SalaryLevelEntity;
import com.learn.pojo.PageRequest;
import com.learn.pojo.PageResultPojo;
import com.learn.service.IJobInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:18
 * 版本： 1.0
 */
@Service
public class JobInfoServiceImpl extends ServiceImpl<JobInfoDao, JobInfoEntity> implements IJobInfoService {

    @Override
    public PageResultPojo getJobInfoPage(PageRequest request) {
        Page<JobInfoEntity> page = new Page<>(request.getPage(), request.getLimit());
        IPage<JobInfoEntity> iPage = baseMapper.getJobInfoPage(page);
        PageResultPojo resultPojo = new PageResultPojo();
        resultPojo.setTotal(iPage.getTotal());
        resultPojo.setRows(iPage.getRecords());
        return resultPojo;
    }

    @Override
    public List<Map<String, Object>> getCountSalaryLevel() {
        SalaryLevelEntity salaryLevel = this.baseMapper.getCountSalaryLevel();
        ArrayList<String> levels = new ArrayList<>();
        levels.add("0-50000");
        levels.add("50001-100000");
        levels.add("100001-150000");
        levels.add("150001-200000");
        levels.add("200001-250000");
        levels.add("250001-300000");
        levels.add("300001-350000");
        levels.add("350001-400000");
        levels.add("400001以上");
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(salaryLevel.getOneLevel());
        counts.add(salaryLevel.getTwoLevel());
        counts.add(salaryLevel.getThreeLevel());
        counts.add(salaryLevel.getFourLevel());
        counts.add(salaryLevel.getFiveLevel());
        counts.add(salaryLevel.getSixLevel());
        counts.add(salaryLevel.getSevenLevel());
        counts.add(salaryLevel.getEightLevel());
        counts.add(salaryLevel.getNineLevel());
        Map<String,Object> map = new HashMap<>();
//        map.put("data",counts);
//        map.put("categories",levels);

        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String,Object> map1= new HashMap<>();
        Map<String,Object> map2= new HashMap<>();
        Map<String,Object> map3= new HashMap<>();
        Map<String,Object> map4= new HashMap<>();
        Map<String,Object> map5= new HashMap<>();
        Map<String,Object> map6= new HashMap<>();
        Map<String,Object> map7= new HashMap<>();
        Map<String,Object> map8= new HashMap<>();
        Map<String,Object> map9= new HashMap<>();
        map1.put("value",salaryLevel.getOneLevel());
        map1.put("name","0-50000");
        map2.put("value",salaryLevel.getTwoLevel());
        map2.put("name","50001-10000");
        map3.put("value",salaryLevel.getThreeLevel());
        map3.put("name","100001-150000");
        map4.put("value",salaryLevel.getFourLevel());
        map4.put("name","150001-200000");
        map5.put("value",salaryLevel.getFiveLevel());
        map5.put("name","200001-250000");
        map6.put("value",salaryLevel.getSixLevel());
        map6.put("name","250001-300000");
        map7.put("value",salaryLevel.getSevenLevel());
        map7.put("name","300001-350000");
        map8.put("value",salaryLevel.getEightLevel());
        map8.put("name","350001-400000");
        map9.put("value",salaryLevel.getNineLevel());
        map9.put("name","400000以上");
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList.add(map5);
        mapList.add(map6);
        mapList.add(map7);
        mapList.add(map8);
        mapList.add(map9);
        return mapList;
    }
}
