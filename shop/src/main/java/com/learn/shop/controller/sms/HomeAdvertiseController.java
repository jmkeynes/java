package com.learn.shop.controller.sms;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.shop.dto.sms.HomeAdvertiseQueryParam;
import com.learn.shop.entity.sms.HomeAdvertiseEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.sms.IHomeAdvertiseService;
import com.learn.shop.vo.sms.AdvertiseListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页轮播广告表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-03
 */
@Api(tags = "首页轮播广告表 前端控制器")
@RestController
@RequestMapping("/sms-home-advertise-entity")
public class HomeAdvertiseController {

    @Resource
    private IHomeAdvertiseService homeAdvertiseService;

    @PostMapping("/getPageHomeAdvertiseList")
    @ApiOperation("广告分页列表查询")
    public ResultBean<IPage<AdvertiseListVo>> getPageHomeAdvertiseList(HomeAdvertiseQueryParam param) {
        return this.homeAdvertiseService.getPageHomeAdvertiseList(param);
    }

    @PostMapping("/saveAdvertise")
    @ApiOperation("广告添加")
    public ResultBean<Boolean> saveAdvertise(HomeAdvertiseEntity entity) {
        return ResultBean.success(this.homeAdvertiseService.save(entity));
    }

    @DeleteMapping("/deleteAdvertiseById")
    @ApiOperation("广告删除")
    public ResultBean<Boolean> deleteAdvertiseById(Long id) {
        return ResultBean.success(this.homeAdvertiseService.removeById(id));
    }

    @DeleteMapping("/batchDeleteAdvertise")
    @ApiOperation("广告批量删除")
    public ResultBean<Boolean> batchDeleteAdvertise(List<HomeAdvertiseEntity> entities) {
        return ResultBean.success(this.homeAdvertiseService.removeByIds(entities));
    }

    @PostMapping("/updateAdvertise")
    @ApiOperation("广告更新")
    public ResultBean<Boolean> updateAdvertise(HomeAdvertiseEntity entity){
        return ResultBean.success(this.homeAdvertiseService.updateById(entity));
    }

    @GetMapping("/getAdvertiseById")
    @ApiOperation("查询单条广告")
    public ResultBean<HomeAdvertiseEntity> getAdvertiseById(Long id){
        return ResultBean.success(this.homeAdvertiseService.getById(id));
    }
}

