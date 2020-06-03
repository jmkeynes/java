package com.learn.shop.entity.sms;

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
 * 优惠券使用、领取历史表
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sms_coupon_history")
public class CouponHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("coupon_id")
    private Long couponId;

    @TableField("member_id")
    private Long memberId;

    @TableField("coupon_code")
    private String couponCode;

    /**
     * 领取人昵称
     */
    @TableField("member_nickname")
    private String memberNickname;

    /**
     * 获取类型：0->后台赠送；1->主动获取
     */
    @TableField("get_type")
    private Integer getType;

    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    @TableField("use_status")
    private Integer useStatus;

    /**
     * 使用时间
     */
    @TableField("use_time")
    private LocalDateTime useTime;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 订单号码
     */
    @TableField("order_sn")
    private String orderSn;


}
