package com.learn.elasticsearch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.elasticsearch.dao.mapper.PmsProductDao;
import com.learn.elasticsearch.dao.repository.EsProductRepository;
import com.learn.elasticsearch.entity.PmsProduct;
import com.learn.elasticsearch.nosql.document.EsProduct;
import com.learn.elasticsearch.service.IEsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 16:00
 * @version： 1.0
 */
@Service
public class EsProductServiceImpl extends ServiceImpl<PmsProductDao, PmsProduct> implements IEsProductService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PmsProductDao productDao;

    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public Boolean importAll() {
        try {
            List<EsProduct> productList = this.productDao.getAllEsProductList();
            Iterable<EsProduct> esProducts = esProductRepository.saveAll(productList);
            Iterator<EsProduct> iterator = esProducts.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("ES初始化异常信息：{}", e.getMessage());
        }
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            esProductRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("商品删除异常：{}", e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean batchDelete(List<Long> ids) {
        try {
            if (!CollectionUtils.isEmpty(ids)) {
                esProductRepository.deleteAll(this.productDao.getEsProductListByIds(ids));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.warn("商品批量删除出错：{}", e.getMessage());
            return false;
        }
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct reust = null;
        EsProduct esProduct = this.productDao.getEsProductById(id);
        if (esProduct != null) {
            reust = esProductRepository.save(esProduct);
        }
        return reust;
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeyword(keyword, keyword, keyword, pageable);
    }
}
