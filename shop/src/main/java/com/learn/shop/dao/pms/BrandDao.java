package com.learn.shop.dao.pms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.pms.BrandQueryParam;
import com.learn.shop.entity.pms.BrandEntity;
import com.learn.shop.vo.pms.BrandVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface BrandDao extends BaseMapper<BrandEntity> {

    /**
     * 品牌分页条件查询
     *
     * @param page  分页参数
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-3
     */
    IPage<BrandVo> getPageBrandList(@Param("page") Page<BrandVo> page, @Param("param") BrandQueryParam param);
}
