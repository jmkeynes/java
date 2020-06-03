package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.CouponQueryParam;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.sms.CouponVo;

/**
 * <p>
 * 优惠卷表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface ICouponService extends IService<CouponEntity> {

    /**
     * 优惠卷列表分页查询
     * @author jwp
     * @date 2020-6-3
     * @param param 查询参数
     */
    ResultBean<IPage<CouponVo>> getPageCouponList(CouponQueryParam param);
}
