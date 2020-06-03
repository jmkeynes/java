package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.HomeRecommendSubjectQueryParam;
import com.learn.shop.entity.sms.HomeRecommendSubjectEntity;
import com.learn.shop.pojo.result.ResultBean;

/**
 * <p>
 * 首页推荐专题表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface IHomeRecommendSubjectService extends IService<HomeRecommendSubjectEntity> {

    ResultBean<IPage<HomeRecommendSubjectEntity>> getPageHomeRecommendSubjectList(HomeRecommendSubjectQueryParam param);
}
