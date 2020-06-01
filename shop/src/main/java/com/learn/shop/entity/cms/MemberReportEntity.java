package com.learn.shop.entity.cms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_member_report")
public class MemberReportEntity implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    @TableField("report_type")
    private Integer reportType;

    /**
     * 举报人
     */
    @TableField("report_member_name")
    private String reportMemberName;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("report_object")
    private String reportObject;

    /**
     * 举报状态：0->未处理；1->已处理
     */
    @TableField("report_status")
    private Integer reportStatus;

    /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
    @TableField("handle_status")
    private Integer handleStatus;

    private String note;


}
