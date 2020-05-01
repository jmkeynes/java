package com.learn.service;

import com.learn.pojo.PageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 创建人：江文谱
 * 创建时间： 2020/5/1 12:05
 * 版本： 1.0
 */
@SpringBootTest
public class IjobInfoServiceTests {

    @Autowired
    private IJobInfoService jobInfoService;

    @Test
    void testGetJobInfoPage(){
        System.out.println(jobInfoService.getJobInfoPage(new PageRequest()).getTotal());
    }

    @Test
    void test(){
        System.out.println(jobInfoService.getCountSalaryLevel());
    }
}
