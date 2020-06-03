package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.BrandRecommendQueryParam;
import com.learn.shop.entity.sms.HomeBrandEntity;
import com.learn.shop.pojo.result.ResultBean;

/**
 * <p>
 * 首页推荐品牌表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface IHomeBrandService extends IService<HomeBrandEntity> {

    /**
     * 推荐品牌根据条件分页查询
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<HomeBrandEntity>> getBrandRecommend(BrandRecommendQueryParam param);


}
