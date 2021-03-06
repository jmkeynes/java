package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductVertifyRecordDao;
import com.learn.shop.entity.pms.ProductVertifyRecordEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductVertifyRecordService;
import com.learn.shop.vo.pms.ProductVertifyRecordInfoVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品审核记录 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductVertifyRecordServiceImpl extends ServiceImpl<ProductVertifyRecordDao, ProductVertifyRecordEntity> implements IProductVertifyRecordService {

    @Override
    public ResultBean<ProductVertifyRecordInfoVo> getVertifyByProductId(Long productId) {
        return ResultBean.success(this.baseMapper.getVertifyByProductId(productId));
    }
}
