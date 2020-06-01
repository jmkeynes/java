package com.learn.shop.service.impl.product;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.product.MemberPriceDao;
import com.learn.shop.entity.product.MemberPriceEntity;
import com.learn.shop.service.product.IMemberPriceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品会员价格表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements IMemberPriceService {

}
