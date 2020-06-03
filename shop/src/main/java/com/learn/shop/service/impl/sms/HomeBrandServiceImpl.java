package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeBrandDao;
import com.learn.shop.dto.sms.BrandRecommendQueryParam;
import com.learn.shop.entity.sms.HomeBrandEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页推荐品牌表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeBrandServiceImpl extends ServiceImpl<HomeBrandDao, HomeBrandEntity> implements IHomeBrandService {

    private static final String COLUMN_BRAND_NAME = "brand_name";

    private static final String COLUMN_RECOMMEND_STATUS = "recommend_status";

    /**
     * 推荐品牌 分页查询
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    @Override
    public ResultBean<IPage<HomeBrandEntity>> getBrandRecommend(BrandRecommendQueryParam param) {

        //分页参数
        Page<HomeBrandEntity> page = new Page<>(param.getPage(), param.getLimit());

        //分页查询参数
        QueryWrapper<HomeBrandEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNoneBlank(param.getBrandName())) {
            wrapper.like(COLUMN_BRAND_NAME, param.getBrandName());
        }
        if (param.getRecommendStatus() != null) {
            wrapper.eq(COLUMN_RECOMMEND_STATUS, param.getRecommendStatus());
        }
        return ResultBean.success(this.page(page, wrapper));
    }
}
