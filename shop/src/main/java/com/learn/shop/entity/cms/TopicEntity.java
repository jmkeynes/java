package com.learn.shop.entity.cms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 话题表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_topic")
public class TopicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("category_id")
    private Long categoryId;

    private String name;

    @TableField("create_time")
    private Date createTime;

    @TableField("start_time")
    private Date startTime;

    @TableField("end_time")
    private Date endTime;

    /**
     * 参与人数
     */
    @TableField("attend_count")
    private Integer attendCount;

    /**
     * 关注人数
     */
    @TableField("attention_count")
    private Integer attentionCount;

    @TableField("read_count")
    private Integer readCount;

    /**
     * 奖品名称
     */
    @TableField("award_name")
    private String awardName;

    /**
     * 参与方式
     */
    @TableField("attend_type")
    private String attendType;

    /**
     * 话题内容
     */
    private String content;


}
