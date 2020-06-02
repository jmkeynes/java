package com.learn.shop.dao.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.shop.entity.pms.SkuStockEntity;
import com.learn.shop.vo.pms.SkuStockListVo;

import java.util.List;

/**
 * <p>
 * sku的库存 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface SkuStockDao extends BaseMapper<SkuStockEntity> {

    List<SkuStockListVo> getSkuStockByProduct(Long productId);

    SkuStockListVo getSkuStockBySkuCode(String skuCode);
}
