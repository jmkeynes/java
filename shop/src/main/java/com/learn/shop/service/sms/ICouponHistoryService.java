package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.CouponHistoryQueryParam;
import com.learn.shop.entity.sms.CouponHistoryEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.sms.CouponHistoryListVo;

/**
 * <p>
 * 优惠券使用、领取历史表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface ICouponHistoryService extends IService<CouponHistoryEntity> {

    /**
     * 优惠卷使用历史记录
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<CouponHistoryListVo>> getPageCouponHistoryList(CouponHistoryQueryParam param);
}
