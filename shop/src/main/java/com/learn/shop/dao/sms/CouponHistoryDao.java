package com.learn.shop.dao.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.sms.CouponHistoryQueryParam;
import com.learn.shop.entity.sms.CouponHistoryEntity;
import com.learn.shop.vo.sms.CouponHistoryListVo;

/**
 * <p>
 * 优惠券使用、领取历史表 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {

    /**
     * 历史信息分页查询
     *
     * @param page  分页参数
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    IPage<CouponHistoryListVo> getPageCouponHistoryList(Page<CouponHistoryListVo> page, CouponHistoryQueryParam param);
}
