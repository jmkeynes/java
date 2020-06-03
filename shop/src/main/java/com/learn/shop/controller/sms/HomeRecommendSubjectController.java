package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.HomeRecommendSubjectQueryParam;
import com.learn.shop.entity.sms.HomeRecommendSubjectEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeRecommendSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页推荐专题表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "首页推荐专题表 前端控制器")
@RestController
@RequestMapping("/sms-home-recommend-subject-entity")
public class HomeRecommendSubjectController {

    @Resource
    private IHomeRecommendSubjectService homeRecommendSubjectService;

    @PostMapping("/getPageHomeRecommendSubjectList")
    @ApiOperation("新品推荐分页查询列表")
    public ResultBean<IPage<HomeRecommendSubjectEntity>> getPageHomeRecommendSubjectList(HomeRecommendSubjectQueryParam param) {
        return this.homeRecommendSubjectService.getPageHomeRecommendSubjectList(param);
    }

    @PostMapping("/updateHomeRecommendSubject")
    @ApiOperation("专题推荐更新")
    public ResultBean<Boolean> updateHomeRecommendSubject(HomeRecommendSubjectEntity entity) {
        return ResultBean.success(this.homeRecommendSubjectService.updateById(entity));
    }

    @PostMapping("/batchUpdateHomeRecommendSubject")
    @ApiOperation("批量更新")
    public ResultBean<Boolean> batchUpdateHomeRecommendSubject(List<HomeRecommendSubjectEntity> entities) {
        return ResultBean.success(this.homeRecommendSubjectService.updateBatchById(entities));
    }

    @DeleteMapping("/deleteHomeRecommendSubjectById")
    @ApiOperation("删除")
    public ResultBean<Boolean> deleteHomeRecommendSubjectById(Long id) {
        return ResultBean.success(this.homeRecommendSubjectService.removeById(id));
    }

    @DeleteMapping("/batchDeleteHomeRecommendSubject")
    @ApiOperation("批量删除")
    public ResultBean<Boolean> batchDeleteHomeRecommendSubject(List<HomeRecommendSubjectEntity> entities) {
        return ResultBean.success(this.homeRecommendSubjectService.removeByIds(entities));
    }

}

