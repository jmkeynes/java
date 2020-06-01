package com.learn.shop.dao.product;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.shop.entity.product.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {

}
