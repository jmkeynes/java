package com.learn.shop.service.impl.sms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.sms.HomeRecommendSubjectDao;
import com.learn.shop.dto.sms.HomeRecommendSubjectQueryParam;
import com.learn.shop.entity.sms.HomeRecommendSubjectEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeRecommendSubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页推荐专题表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Service
public class HomeRecommendSubjectServiceImpl extends ServiceImpl<HomeRecommendSubjectDao, HomeRecommendSubjectEntity> implements IHomeRecommendSubjectService {

    private static final String SUBJECT_NAME = "subject_name";

    private static final String RECOMMEND_STATUS = "recommend_status";

    @Override
    public ResultBean<IPage<HomeRecommendSubjectEntity>> getPageHomeRecommendSubjectList(HomeRecommendSubjectQueryParam param) {
        Page<HomeRecommendSubjectEntity> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<HomeRecommendSubjectEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(param.getSubjectName())) {
            wrapper.like(SUBJECT_NAME, param.getSubjectName());
        }
        if (param.getRecommendStatus() != null) {
            wrapper.eq(RECOMMEND_STATUS, param.getRecommendStatus());
        }
        return ResultBean.success(this.page(page, wrapper));
    }
}
