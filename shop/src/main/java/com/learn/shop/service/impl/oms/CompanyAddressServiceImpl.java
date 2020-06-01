package com.learn.shop.service.impl.oms;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.oms.CompanyAddressDao;
import com.learn.shop.entity.oms.CompanyAddressEntity;
import com.learn.shop.service.oms.ICompanyAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司收发货地址表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class CompanyAddressServiceImpl extends ServiceImpl<CompanyAddressDao, CompanyAddressEntity> implements ICompanyAddressService {

}
