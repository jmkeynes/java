package com.learn.shop.service.impl.pms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.shop.dao.pms.ProductDao;
import com.learn.shop.dto.pms.ProductDto;
import com.learn.shop.dto.pms.ProductQueryParam;
import com.learn.shop.entity.cms.PrefrenceAreaProductRelationEntity;
import com.learn.shop.entity.cms.SubjectProductRelationEntity;
import com.learn.shop.entity.pms.ProductEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.cms.ISubjectProductRelationService;
import com.learn.shop.service.pms.IProductService;
import com.learn.shop.vo.pms.ProductListVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    @Resource
    private ISubjectProductRelationService subjectProductRelationService;

    /**
     * 分页查询
     *
     * @param param 分页条件查询
     * @author jwp
     * @date 2020-6-2
     */
    @Override
    public ResultBean<IPage<ProductListVo>> getPageProductInfo(ProductQueryParam param) {
        Page<ProductListVo> vo = new Page<>(param.getPage(), param.getLimit());
        return ResultBean.success(this.baseMapper.getPageProductInfo(vo, param));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultBean<Boolean> addProduct(ProductDto productDto) {
        int success = this.baseMapper.insert(productDto);
        if (success!=1) {
            return ResultBean.failed(false);
        }
        Long keyId = productDto.getId();

        //专题
        SubjectProductRelationEntity relationEntity = new SubjectProductRelationEntity();
        relationEntity.setProductId(keyId);
        relationEntity.setSubjectId(productDto.getSubjectId());

        //优选专区
        PrefrenceAreaProductRelationEntity entity = new PrefrenceAreaProductRelationEntity();
        entity.setPrefrenceAreaId(productDto.getPrefrenceAreaId());
        entity.setProductId(keyId);

        return ResultBean.success(true);
    }

}