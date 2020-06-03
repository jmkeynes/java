package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.CouponDao;
import com.learn.shop.dto.sms.CouponQueryParam;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.ICouponService;
import com.learn.shop.vo.sms.CouponInfoVo;
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

    /**
     * 分页列表
     *
     * @param param 查询参数
     * @author jwo
     * @date 2020-6-3
     */
    @Override
    public ResultBean<IPage<CouponVo>> getPageCouponList(CouponQueryParam param) {
        Page<CouponVo> page = new Page<>(param.getPage(), param.getLimit());
        return ResultBean.success(this.baseMapper.getPageCouponList(page, param));
    }

    /**
     * 优惠卷详情
     *
     * @param id 优惠卷id
     * @author jwp
     * @date 2020-6-3
     */
    @Override
    public ResultBean<CouponInfoVo> getCouponById(Long id) {
        return ResultBean.success(this.baseMapper.getCouponById(id));
    }
}
