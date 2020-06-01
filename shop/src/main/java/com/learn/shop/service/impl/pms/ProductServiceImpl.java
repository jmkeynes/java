package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductDao;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.request.PageRequest;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements IProductService {

    @Override
    public ResultBean<IPage<ProductEntity>> getPageProductInfo(PageRequest pageRequest) {
        Page<ProductEntity> page = new Page<>(pageRequest.getPage(),pageRequest.getLimit());
        Page<ProductEntity> result = this.page(page);
        return ResultBean.success(result);
    }
}
