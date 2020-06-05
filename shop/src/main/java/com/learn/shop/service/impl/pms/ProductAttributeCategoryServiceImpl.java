package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductAttributeCategoryDao;
import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductAttributeCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryDao, ProductAttributeCategoryEntity> implements IProductAttributeCategoryService {

    /**
     * 产品属性分类分页
     *
     * @param pageRequest 分页参数
     * @author jwp
     * @date 2020-6-6
     */
    @Override
    public ResultBean<IPage<ProductAttributeCategoryEntity>> getPageProductAttributeCategory(PageRequest pageRequest) {
        Page<ProductAttributeCategoryEntity> page = new Page<>(pageRequest.getPage(), pageRequest.getLimit());
        return ResultBean.success(page(page));
    }
}
