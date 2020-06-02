package com.learn.shop.service.pms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.shop.entity.pms.AlbumEntity;
import com.learn.shop.pojo.result.ResultBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 相册表 服务类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
public interface IAlbumService extends IService<AlbumEntity> {

    ResultBean<String> addAlbum(MultipartFile files);
}
