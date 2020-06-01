package com.learn.shop.service.impl.product;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.BrandDao;
import com.learn.shop.entity.product.BrandEntity;
import com.learn.shop.service.product.IBrandService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements IBrandService {

}
