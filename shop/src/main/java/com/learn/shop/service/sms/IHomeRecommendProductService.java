package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.HomeNewProductQueryParam;
import com.learn.shop.entity.sms.HomeRecommendProductEntity;
import com.learn.shop.pojo.result.ResultBean;

/**
 * <p>
 * 人气推荐商品表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface IHomeRecommendProductService extends IService<HomeRecommendProductEntity> {

    /**
     * 人气商品分页查询
     *
     * @param param 查询参数
     * @author jwo
     * @date 2020-6-3
     */
    ResultBean<IPage<HomeRecommendProductEntity>> getPageHomeNewProductList(HomeNewProductQueryParam param);
}
