package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.SkuStockDao;
import com.learn.shop.entity.pms.SkuStockEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.ISkuStockService;
import com.learn.shop.vo.pms.SkuStockListVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class SkuStockServiceImpl extends ServiceImpl<SkuStockDao, SkuStockEntity> implements ISkuStockService {

    @Override
    public ResultBean<List<SkuStockListVo>> getSkuStockByProduct(Long productId) {
        return ResultBean.success(this.baseMapper.getSkuStockByProduct(productId));
    }

    @Override
    public ResultBean<SkuStockListVo> getSkuStockBySkuCode(String skuCode) {
        return ResultBean.success(this.baseMapper.getSkuStockBySkuCode(skuCode));
    }
}
