package com.learn.shop.dao.sms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.sms.HomeAdvertiseQueryParam;
import com.learn.shop.entity.sms.HomeAdvertiseEntity;
import com.learn.shop.vo.sms.AdvertiseListVo;

/**
 * <p>
 * 首页轮播广告表 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface HomeAdvertiseDao extends BaseMapper<HomeAdvertiseEntity> {

    IPage<AdvertiseListVo> getPageHomeAdvertiseList(Page<AdvertiseListVo> page, HomeAdvertiseQueryParam param);
}

