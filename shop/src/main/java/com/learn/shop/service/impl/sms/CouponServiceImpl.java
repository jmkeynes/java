package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponDao;
import com.learn.shop.dto.sms.CouponQueryParam;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.ICouponService;
import com.learn.shop.vo.sms.CouponVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠卷表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements ICouponService {

    @Override
    public ResultBean<IPage<CouponVo>> getPageCouponList(CouponQueryParam param) {
        Page<CouponVo> page = new Page<>(param.getPage(),param.getLimit());
        return ResultBean.success(this.baseMapper.getPageCouponList(page,param));
    }
}
