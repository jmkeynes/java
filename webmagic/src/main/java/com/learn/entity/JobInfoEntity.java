package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
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
@ApiModel("职位信息")
public class JobInfoEntity implements Serializable {

    /**
     * 主键id 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiParam(name = "id", value = "主键id")
    private Long id;

    @ApiModelProperty(name = "companyName", value = "公司名称", dataType = "String")
    @TableField(value = "company_name")
    private String companyName;

    @ApiModelProperty(name = "companyAddr", value = "公司地址", dataType = "String")
    @TableField(value = "company_addr")
    private String companyAddr;

    @ApiModelProperty(name = "companyInfo", value = "公司信息", dataType = "String")
    @TableField(value = "company_info")
    private String companyInfo;

    @ApiModelProperty(name = "jobName", value = "职位名称", dataType = "String")
    @TableField(value = "job_name")
    private String jobName;

    @ApiModelProperty(name = "jobAddr", value = "工作地址", dataType = "String")
    @TableField(value = "job_addr")
    private String jobAddr;

    @ApiModelProperty(name = "jobInfo", value = "职位信息", dataType = "String")
    @TableField(value = "job_info")
    private String jobInfo;

    @ApiModelProperty(name = "salaryMin", value = "最小工资", dataType = "Integer")
    @TableField(value = "salary_min")
    private Integer salaryMin;

    @TableField(value = "salary_max")
    @ApiModelProperty(name = "salaryMax", value = "最大工资", dataType = "Integer")
    private Integer salaryMax;

    @ApiModelProperty(name = "url", value = "职位详情url", dataType = "String")
    private String url;

    @ApiModelProperty(name = "time", value = "职位发布时间", dataType = "String")
    private String time;

}
