package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.ProductVertifyRecordEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.pms.ProductVertifyRecordInfoVo;

/**
 * <p>
 * 商品审核记录 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IProductVertifyRecordService extends IService<ProductVertifyRecordEntity> {

    ResultBean<ProductVertifyRecordInfoVo> getVertifyByProductId(Long productId);
}
