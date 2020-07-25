package com.learn.databases_cluster.controller;

import com.learn.databases_cluster.entity.CmsHelp;
import com.learn.databases_cluster.service.CmsHelpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 帮助表(CmsHelp)表控制层
 *
 * @author makejava
 * @since 2020-07-19 20:21:10
 */
@RestController
@RequestMapping("cmsHelp")
public class CmsHelpController {
    /**
     * 服务对象
     */
    @Resource
    private CmsHelpService cmsHelpService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CmsHelp selectOne(Long id) {
        return this.cmsHelpService.queryById(id);
    }

}
