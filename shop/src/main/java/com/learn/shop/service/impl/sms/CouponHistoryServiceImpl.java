package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponHistoryDao;
import com.learn.shop.dto.sms.CouponHistoryQueryParam;
import com.learn.shop.entity.sms.CouponHistoryEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.ICouponHistoryService;
import com.learn.shop.vo.sms.CouponHistoryListVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券使用、领取历史表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryDao, CouponHistoryEntity> implements ICouponHistoryService {

    @Override
    public ResultBean<IPage<CouponHistoryListVo>> getPageCouponHistoryList(CouponHistoryQueryParam param) {
        Page<CouponHistoryListVo> page = new Page<>(param.getPage(), param.getLimit());
        return ResultBean.success(this.baseMapper.getPageCouponHistoryList(page, param));
    }
}
