package com.learn.shop.controller;

import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.ISolrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/15 18:19
 * @ClassName SearchController
 */
@Api(tags = "solr商品搜索")
@Controller
@RequestMapping("/search")
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Resource
    private ISolrService solrService;

    @PostMapping("/searchProduct")
    @ResponseBody
    @ApiOperation("关键词搜索")
    public ResultBean searchProduct(@RequestParam(name = "keyword", required = false, defaultValue = "银色") String keyword,
                                    @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "limit", required = false, defaultValue = "40") Integer limit) {
        ResultBean bean = solrService.searchProduct(keyword, page, limit);
        LOGGER.info("\n{}", bean);
        return bean;
    }
}
