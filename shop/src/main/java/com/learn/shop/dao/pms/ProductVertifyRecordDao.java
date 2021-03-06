package com.learn.shop.dao.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.shop.entity.pms.ProductVertifyRecordEntity;
import com.learn.shop.vo.pms.ProductVertifyRecordInfoVo;

/**
 * <p>
 * 商品审核记录 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface ProductVertifyRecordDao extends BaseMapper<ProductVertifyRecordEntity> {

    ProductVertifyRecordInfoVo getVertifyByProductId(Long productId);
}
