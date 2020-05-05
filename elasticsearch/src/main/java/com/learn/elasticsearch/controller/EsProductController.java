package com.learn.elasticsearch.controller;

import com.learn.elasticsearch.nosql.document.EsProduct;
import com.learn.elasticsearch.pojo.Result;
import com.learn.elasticsearch.service.IEsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/4 16:28
 * @version： 1.0
 */
@Controller
@RequestMapping("/esProduct")
@Api(tags = "商品搜索管理")
public class EsProductController {

    @Autowired
    private IEsProductService productService;

    @PostMapping("/importAll")
    @ResponseBody
    @ApiOperation(value = "导入所有数据库中的商品信息到es")
    public Result<Boolean> importAll() {
        return Result.success(productService.importAll());
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    @ApiOperation("根据id删除商品")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(this.productService.delete(id));
    }

    @PostMapping("/batchDelete")
    @ResponseBody
    @ApiOperation(value = "根据id批量删除商品")
    public Result<Boolean> batchDelete(@RequestParam("ids") List<Long> ids) {
        return Result.success(this.productService.batchDelete(ids));
    }

    @PostMapping("/create/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id创建商品")
    public Result<EsProduct> create(@PathVariable Long id) {
        return Result.success(this.productService.create(id));
    }

    @GetMapping("/search")
    @ResponseBody
    @ApiOperation(value = "简单搜索")
    public Result<Page<EsProduct>> search(@RequestParam(required = false) String keyword,
                                          @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(this.productService.search(keyword, pageNum, pageSize));
    }

}
