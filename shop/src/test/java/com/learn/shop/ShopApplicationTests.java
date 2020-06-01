package com.learn.shop;

import com.learn.shop.entity.pms.ProductAttributeCategoryEntity;
import com.learn.shop.service.cms.*;
import com.learn.shop.service.oms.*;
import com.learn.shop.service.pms.*;
import com.learn.shop.service.ums.*;
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

    @Autowired
    private IHelpCategoryService helpCategoryService;

    @Autowired
    private IHelpService helpService;

    @Autowired
    private IMemberReportService memberReportService;

    @Autowired
    private IPrefrenceAreaProductRelationService prefrenceAreaProductRelationService;

    @Autowired
    private IPrefrenceAreaService prefrenceAreaService;

    @Autowired
    private ISubjectCategoryService subjectCategoryService;

    @Autowired
    private ISubjectCommentService subjectCommentService;

    @Autowired
    private ISubjectProductRelationService subjectProductRelationService;

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private ITopicCategoryService topicCategoryService;

    @Autowired
    private ITopicCommentService topicCommentService;

    @Autowired
    private ITopicService topicService;

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private ICompanyAddressService companyAddressService;

    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IOrderOperateHistoryService orderOperateHistoryService;

    @Autowired
    private IOrderReturnApplyService orderReturnApplyService;

    @Autowired
    private IOrderReturnReasonService orderReturnReasonService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderSettingService orderSettingService;

    @Autowired
    private IAdminPermissionRelationService adminPermissionRelationService;

    @Autowired
    private IAdminRoleRelationService adminRoleRelationService;

    @Autowired
    private IAdminLoginLogService adminLoginLogService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IGrowthChangeHistoryService growthChangeHistoryService;

    @Autowired
    private IIntegrationChangeHistoryService iIntegrationChangeHistoryService;

    @Autowired
    private IIntegrationConsumeSettingService iIntegrationConsumeSettingService;

    @Autowired
    private IMemberLevelService memberLevelService;

    @Autowired
    private IMemberLoginLogService memberLoginLogService;

    @Autowired
    private IMemberMemberTagRelationService memberMemberTagRelationService;

    @Autowired
    private IMemberProductCategoryRelationService memberProductCategoryRelationService;

    @Autowired
    private IMemberReceiveAddressService memberReceiveAddressService;

    @Autowired
    private IMemberRuleSettingService memberRuleSettingService;

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IMemberStatisticsInfoService memberStatisticsInfoService;

    @Autowired
    private IMemberTagService memberTagService;

    @Autowired
    private IMemberTaskService memberTaskService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IResourceCategoryService resourceCategoryService;

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IRoleMenuRelationService roleMenuRelationService;

    @Autowired
    private IRoleService roleService;

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

        System.out.println(roleService.list().size());
        System.out.println(roleMenuRelationService.list().size());
        System.out.println(resourceService.list().size());
        System.out.println(resourceCategoryService.list().size());

        System.out.println(permissionService.list().size());
        System.out.println(memberTagService.list().size());
        System.out.println(memberStatisticsInfoService.list().size());
        System.out.println(memberRuleSettingService.list().size());
        System.out.println(adminLoginLogService.list().size());
        System.out.println(adminService.list().size());
        System.out.println(iIntegrationConsumeSettingService.list().size());
        System.out.println(memberLevelService.list().size());
        System.out.println(growthChangeHistoryService.list().size());
        System.out.println(iIntegrationChangeHistoryService.list().size());
        System.out.println(adminRoleRelationService.list().size());
        System.out.println(memberLoginLogService.list().size());
        System.out.println(memberReceiveAddressService.list().size());
        System.out.println(memberTaskService.list().size());
        System.out.println(memberService.list().size());
        System.out.println(memberProductCategoryRelationService.list().size());
        System.out.println(orderSettingService.list().size());
        System.out.println(cartItemService.list().size());
        System.out.println(companyAddressService.list().size());
        System.out.println(orderItemService.list().size());
        System.out.println(orderOperateHistoryService.list().size());
        System.out.println(orderReturnApplyService.list().size());
        System.out.println(orderReturnReasonService.list().size());
        System.out.println(orderService.list().size());
        System.out.println(adminPermissionRelationService.list().size());
        System.out.println(memberMemberTagRelationService.list().size());
        System.out.println(menuService.list().size());
        System.out.println(topicService.list().size());
        System.out.println(topicCommentService.list().size());
        System.out.println(topicCategoryService.list().size());
        System.out.println(subjectService.list().size());
        System.out.println(subjectProductRelationService.list().size());
        System.out.println(subjectCommentService.list().size());
        System.out.println(subjectCategoryService.list().size());
        System.out.println(helpCategoryService.list().size());
        System.out.println(helpService.list().size());
        System.out.println(memberReportService.list().size());
        System.out.println(prefrenceAreaProductRelationService.list().size());
        System.out.println(prefrenceAreaService.list().size());

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
