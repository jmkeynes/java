package com.learn.shop.dao.pms;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.shop.dto.pms.ProductQueryParam;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.vo.pms.ProductListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface ProductDao extends BaseMapper<ProductEntity> {

    /**
     * 分页查询
     *
     * @param page  分页参数
     * @param param 查询参数
     * @author jwp
     * @date 2020-6-2
     * @return 查询结果
     */
    IPage<ProductListVo> getPageProductInfo(@Param("page") Page<ProductListVo> page, @Param("param") ProductQueryParam param);

    /**
     * 查询所有未删除的商品信息
     *
     * @date 2020-6-15
     * @author jwp
     * @return 查询结果
     */
    List<ProductListVo> getAllProductByNotDelete();


}
