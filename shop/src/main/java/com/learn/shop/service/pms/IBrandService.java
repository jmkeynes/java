package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.pms.BrandQueryParam;
import com.learn.shop.entity.pms.BrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.pms.BrandVo;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IBrandService extends IService<BrandEntity> {

    /**
     * 查询商品品牌名称分页列表
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<BrandVo>> getPageBrandList(BrandQueryParam param);
}
