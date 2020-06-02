package com.learn.shop.controller.pms;


import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IAlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 相册表 前端控制器
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Api(tags = "相册表 前端控制器")
@RestController
@RequestMapping("/pms-album")
public class AlbumController {

    @Resource
    private IAlbumService albumService;

    @ApiOperation("文件批量上传")
    @PostMapping("/batchAddAlbum")
    public ResultBean<String> batchAddAlbum(MultipartFile files) {
        return albumService.addAlbum(files);
    }
}

