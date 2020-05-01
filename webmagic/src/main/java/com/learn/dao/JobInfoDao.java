package com.learn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.entity.JobInfoEntity;
import com.learn.entity.SalaryLevelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:07
 * 版本： 1.0
 */
@Mapper
public interface JobInfoDao extends BaseMapper<JobInfoEntity> {

    @Select("Select * from t_job")
    IPage<JobInfoEntity> getJobInfoPage(Page<JobInfoEntity> page);

    @Select("\n" +
            "SELECT \n" +
            " COUNT(CASE WHEN salary_min > '400001' THEN salary_min END) AS 'oneLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '350001' AND '400000' THEN salary_min END) AS 'twoLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '300001' AND '350000' THEN salary_min END) AS 'threeLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '250001' AND '300000' THEN salary_min END) AS 'fourLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '200001' AND '250000' THEN salary_min END) AS 'fiveLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '150001' AND '200000' THEN salary_min END) AS 'sixLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '100001' AND '150000' THEN salary_min END) AS 'sevenLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '50001' AND '100000' THEN salary_min END) AS 'eightLevel'\n" +
            ",COUNT(CASE WHEN salary_min BETWEEN '0'AND'50000' THEN salary_min END) AS 'nineLevel'\n" +
            " FROM t_job ")
    SalaryLevelEntity getCountSalaryLevel();

}
