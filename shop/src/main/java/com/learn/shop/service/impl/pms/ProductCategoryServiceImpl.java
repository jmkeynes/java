package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductCategoryDao;
import com.learn.shop.dto.pms.ProductCategoryParam;
import com.learn.shop.entity.pms.ProductCategoryEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductCategoryService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategoryEntity> implements IProductCategoryService {

    private static final String COLUMN_PARENT_ID = "parent_id";

    /**
     * 获取父类
     *
     * @param param 查询参数 父类id
     * @author jwp
     * @date 2020-6-2
     */
    @Override
    public ResultBean<IPage<ProductCategoryEntity>> getPageProductCategory(ProductCategoryParam param) {
        Page<ProductCategoryEntity> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<ProductCategoryEntity> wrapper = new QueryWrapper<>();
        if (param.getParentId() != null) {
            wrapper.eq(COLUMN_PARENT_ID, param.getParentId());
        } else {
            wrapper.eq(COLUMN_PARENT_ID, 0);
        }
        return ResultBean.success(this.page(page, wrapper));
    }

    /**
     * 根据删除商品类型
     *
     * @param id id 商品类型id
     * @author jwp
     * @date 2020-6-2
     */
    @Override
    public Boolean deleteProductCategoryById(Long id) {
        try {
            //构建查询条件
            QueryWrapper<ProductCategoryEntity> wrapper = new QueryWrapper<>();
            wrapper.eq(COLUMN_PARENT_ID, id);

            //查询是否还有子类
            List<ProductCategoryEntity> productCategoryEntities = this.list(wrapper);
            if (CollectionUtils.isNotEmpty(productCategoryEntities)) {

                //删除子类
                this.removeByIds(productCategoryEntities);
            }
            //删除自身
            this.removeById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 商品更新
     *
     * @param entity 商品实例
     * @author jwp
     * @date 2020-6-2
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean<Integer> updateProductCategory(ProductCategoryEntity entity) {
        return ResultBean.success(this.baseMapper.updateById(entity));
    }
}
