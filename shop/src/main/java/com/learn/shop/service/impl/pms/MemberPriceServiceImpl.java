package com.learn.shop.service.impl.pms;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.MemberPriceDao;
import com.learn.shop.entity.pms.MemberPriceEntity;
import com.learn.shop.service.pms.IMemberPriceService;
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
