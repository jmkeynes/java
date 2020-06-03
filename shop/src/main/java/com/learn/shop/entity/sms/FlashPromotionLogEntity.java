package com.learn.shop.entity.sms;

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
 * 限时购通知记录
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_flash_promotion_log")
public class FlashPromotionLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("member_id")
    private Integer memberId;

    @TableField("product_id")
    private Long productId;

    @TableField("member_phone")
    private String memberPhone;

    @TableField("product_name")
    private String productName;

    /**
     * 会员订阅时间
     */
    @TableField("subscribe_time")
    private Date subscribeTime;

    @TableField("send_time")
    private Date sendTime;


}
