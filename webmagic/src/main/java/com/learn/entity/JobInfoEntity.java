package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:06
 * 版本： 1.0
 */
@Setter
@Getter
@ToString
@TableName("t_job")
public class JobInfoEntity implements Serializable {

    /**
     * 主键id 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "公司名称")
    @TableField(value = "company_name")
    private String companyName;

    @ApiModelProperty(value = "公司地址")
    @TableField(value = "company_addr")
    private String companyAddr;

    @ApiModelProperty(value = "公司信息")
    @TableField(value = "company_info")
    private String companyInfo;

    @ApiModelProperty(value = "职位名称")
    @TableField(value = "job_name")
    private String jobName;

    @ApiModelProperty(value = "工作地址")
    @TableField(value = "job_addr")
    private String jobAddr;

    @ApiModelProperty(value = "职位信息")
    @TableField(value = "job_info")
    private String jobInfo;

    @ApiModelProperty(value = "最小工资")
    @TableField(value = "salary_min")
    private Integer salaryMin;

    @TableField(value = "salary_max")
    @ApiModelProperty(value = "最大工资")
    private Integer salaryMax;

    @ApiModelProperty(value = "职位详情url")
    private String url;

    @ApiModelProperty(value = "职位发布时间")
    private String time;

}
