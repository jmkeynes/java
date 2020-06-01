package com.learn.shop;

import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.service.product.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    private IProductService productService;

    @Autowired
    private IAlbumPicService albumPicService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICommentReplayService commentReplayService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IFeightTemplateService feightTemplateService;

    @Autowired
    private IMemberPriceService memberPriceService;

    @Autowired
    private IProductAttributeCategoryService productAttributeCategoryService;

    @Autowired
    private IProductAttributeValueService attributeValueService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @Autowired
    private IProductAttributeService productAttributeService;

    @Autowired
    private ISkuStockService skuStockService;

    @Autowired
    private IProductVertifyRecordService productVertifyRecordService;

    @Autowired
    private IProductOperateLogService productOperateLogService;

    @Autowired
    private IProductLadderService productLadderService;

    @Autowired
    private IProductFullReductionService productFullReductionService;
    @Test
    void contextLoads() {
        System.out.println(this.productService.list().size());
        System.out.println(this.albumPicService.list().size());
        System.out.println(this.albumService.list().size());
        System.out.println(this.attributeValueService.list().size());
        System.out.println(this.productAttributeCategoryService.list().size());
        System.out.println(this.productAttributeService.list().size());
        System.out.println(this.productOperateLogService.list().size());
        System.out.println(this.productLadderService.list().size());
        System.out.println(this.productFullReductionService.list().size());
        System.out.println(this.productVertifyRecordService.list().size());
        System.out.println(this.brandService.list().size());
        System.out.println(this.skuStockService.list().size());
        System.out.println(this.commentReplayService.list().size());
        System.out.println(this.commentService.list().size());
        System.out.println(this.productCategoryService.list().size());
        System.out.println(this.feightTemplateService.list().size());
        System.out.println(this.memberPriceService.list().size());
    }

    @Test
    void testAdd(){
        ProductAttributeCategoryEntity entity = new ProductAttributeCategoryEntity();
        entity.setAttributeCount(2000);
        entity.setName("test");
        entity.setParamCount(2000);
        System.out.println(this.productAttributeCategoryService.save(entity));
    }

}
