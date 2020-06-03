package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeNewProductDao;
import com.learn.shop.dto.sms.HomeNewProductQueryParam;
import com.learn.shop.entity.sms.HomeNewProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeNewProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新鲜好物表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeNewProductServiceImpl extends ServiceImpl<HomeNewProductDao, HomeNewProductEntity> implements IHomeNewProductService {

    private static final String PRODUCT_NAME = "product_name";

    private static final String RECOMMEND_STATUS = "recommend_status";

    @Override
    public ResultBean<IPage<HomeNewProductEntity>> getPageHomeNewProductList(HomeNewProductQueryParam param) {
        Page<HomeNewProductEntity> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<HomeNewProductEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(param.getProductName())) {
            wrapper.like(PRODUCT_NAME, param.getProductName());
        }
        if (param.getRecommendStatus() != null) {
            wrapper.eq(RECOMMEND_STATUS, param.getRecommendStatus());
        }
        return ResultBean.success(this.page(page, wrapper));
    }
}
