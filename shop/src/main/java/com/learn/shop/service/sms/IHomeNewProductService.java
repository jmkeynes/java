package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.HomeNewProductQueryParam;
import com.learn.shop.entity.sms.HomeNewProductEntity;
import com.learn.shop.pojo.result.ResultBean;

/**
 * <p>
 * 新鲜好物表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface IHomeNewProductService extends IService<HomeNewProductEntity> {

    /**
     * 新品分页查询列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<HomeNewProductEntity>> getPageHomeNewProductList(HomeNewProductQueryParam param);
}
