package com.learn.shop.service.sms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.dto.sms.HomeAdvertiseQueryParam;
import com.learn.shop.entity.sms.HomeAdvertiseEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.vo.sms.AdvertiseListVo;

/**
 * <p>
 * 首页轮播广告表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
public interface IHomeAdvertiseService extends IService<HomeAdvertiseEntity> {

    /**
     * 广告列表查询分页
     *
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    ResultBean<IPage<AdvertiseListVo>> getPageHomeAdvertiseList(HomeAdvertiseQueryParam param);
}
