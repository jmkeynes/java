package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.SkuStockEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.pms.SkuStockListVo;

import java.util.List;

/**
 * <p>
 * sku的库存 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface ISkuStockService extends IService<SkuStockEntity> {

    /**
     * 根据id查询库存
     *
     * @param productId 商品id
     * @author jwp
     * @date 2020-6-2
     */
    ResultBean<List<SkuStockListVo>> getSkuStockByProduct(Long productId);

    /**
     * 根据库存编号查询库存信息
     *
     * @param skuCode 库存编号
     * @author jwp
     * @date 2020-6-2
     */
    ResultBean<SkuStockListVo> getSkuStockBySkuCode(String skuCode);
}
