package com.learn.shop.entity.ums;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 积分变化历史记录表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ums_integration_change_history")
public class IntegrationChangeHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("member_id")
    private Long memberId;

    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 改变类型：0->增加；1->减少
     */
    @TableField("change_type")
    private Integer changeType;

    /**
     * 积分改变数量
     */
    @TableField("change_count")
    private Integer changeCount;

    /**
     * 操作人员
     */
    @TableField("operate_man")
    private String operateMan;

    /**
     * 操作备注
     */
    @TableField("operate_note")
    private String operateNote;

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    @TableField("source_type")
    private Integer sourceType;


}
