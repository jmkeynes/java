package com.learn.shop.dao.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.sms.CouponQueryParam;
import com.learn.shop.entity.sms.CouponEntity;
import com.learn.shop.vo.sms.CouponVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 优惠卷表 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface CouponDao extends BaseMapper<CouponEntity> {

    /**
     * 优惠卷查询分页
     *
     * @param page  分页参数
     * @param param 查询条件
     * @author jwp
     * @date 2020-6-3
     */
    IPage<CouponVo> getPageCouponList(@Param("page") Page<CouponVo> page, @Param("param") CouponQueryParam param);
}
