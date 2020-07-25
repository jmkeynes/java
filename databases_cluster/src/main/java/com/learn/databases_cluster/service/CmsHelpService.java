package com.learn.databases_cluster.service;

import com.learn.databases_cluster.entity.CmsHelp;

import java.util.List;

/**
 * 帮助表(CmsHelp)表服务接口
 *
 * @author makejava
 * @since 2020-07-19 20:21:10
 */
public interface CmsHelpService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CmsHelp queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CmsHelp> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cmsHelp 实例对象
     * @return 实例对象
     */
    CmsHelp insert(CmsHelp cmsHelp);

    /**
     * 修改数据
     *
     * @param cmsHelp 实例对象
     * @return 实例对象
     */
    CmsHelp update(CmsHelp cmsHelp);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
