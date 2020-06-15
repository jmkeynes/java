package com.learn.shop.service.impl.pms;

import com.alibaba.fastjson.JSON;
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
import com.learn.shop.service.IRedisService;
import com.learn.shop.service.ISolrService;
import com.learn.shop.service.pms.IProductService;
import com.learn.shop.vo.pms.ProductListVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Value("${redis.pre.product}")
    private String key;

    @Value("${solr.default.name:}")
    private String name;

    @Resource
    private IRedisService redisService;

    @Resource
    private ISolrService solrService;

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
        if (success != 1) {
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
        ProductEntity productEntity = this.getById(keyId);
        ProductListVo vo = getProductListVo(productEntity);


        if (productEntity.getDeleteStatus() != null && productEntity.getDeleteStatus() == 0) {

            //添加至solr
            this.solrService.addSolrHome(vo);

            //添加值缓存
            this.redisService.addRedis(key + ":" + keyId, JSON.toJSONString(vo));
        }
        return ResultBean.success(true);
    }

    /**
     * 将product数据封装成productListVo，方便管理
     *
     * @param productEntity 实体类数据
     * @return vo
     */
    private ProductListVo getProductListVo(ProductEntity productEntity) {
        ProductListVo vo = new ProductListVo();
        vo.setId(productEntity.getId());
        //0->未审核；1->审核通过
        vo.setVerifyStatusStr(productEntity.getVerifyStatus() == 0 ? "未审核" : "审核通过");
        vo.setVerifyStatus(productEntity.getVerifyStatus());
        vo.setSort(productEntity.getSort());
        //0->不推荐；1->推荐
        vo.setRecommandStatusStr(productEntity.getRecommandStatus() == 0 ? "不推荐" : "推荐");
        vo.setRecommandStatus(productEntity.getRecommandStatus());
        //0->下架；1->上架
        vo.setPublishStatusStr(productEntity.getPublishStatus() == 0 ? "下架" : "上架");
        vo.setPublishStatus(productEntity.getPublishStatus());
        vo.setProductSn(productEntity.getProductSn());
        vo.setPic(productEntity.getPic());
        //0->不是新品；1->新品
        vo.setNewStatus(productEntity.getNewStatus());
        vo.setNewStatusStr(productEntity.getNewStatus() == 0 ? "不是新品" : "新品");
        vo.setName(productEntity.getName());
        vo.setBrandName(productEntity.getBrandName());
        vo.setBrandId(productEntity.getBrandId());
        vo.setPrice(productEntity.getPrice().toString());
        vo.setProductCategoryId(productEntity.getProductCategoryId());
        return vo;
    }

    @Override
    public ResultBean<Boolean> initHotProductToRedisData() {
        List<ProductListVo> result = this.baseMapper.getAllProductByNotDelete();
        if (CollectionUtils.isNotEmpty(result)) {
            Map<String, String> map = new HashMap<>();
            result.forEach(entity -> {
                map.put(key + ":" + entity.getId(), JSON.toJSONString(entity));
            });
            return ResultBean.success(redisService.batchAddRedis(map));
        }
        return ResultBean.failed();
    }

    @Override
    public ResultBean<Boolean> initProductToSolrData() {
        List<ProductListVo> result = this.baseMapper.getAllProductByNotDelete();
        if (CollectionUtils.isNotEmpty(result)) {
            return solrService.batchAddSolrHome(result);
        }
        return ResultBean.failed();
    }

}