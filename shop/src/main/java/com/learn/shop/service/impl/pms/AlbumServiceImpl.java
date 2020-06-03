package com.learn.shop.service.impl.pms;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.learn.shop.dao.pms.AlbumDao;
import com.learn.shop.entity.pms.AlbumEntity;
import com.learn.shop.pojo.result.ResultBean;
import com.learn.shop.service.pms.IAlbumService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * <p>
 * 相册表 服务实现类
 * </p>
 *
 * @author 江文谱
 * @since 2020-06-01
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumDao, AlbumEntity> implements IAlbumService {

    @Value("${images.url.pre}")
    private String preUrl;

    @Resource
    private FastFileStorageClient fileStorageClient;

    @Override
    public ResultBean<String> addAlbum(MultipartFile file) {
        AlbumEntity entity = new AlbumEntity();
        String filename = file.getOriginalFilename();
        try {
            assert filename != null;
            String suffix = filename.split("\\.")[1];
            StorePath storePath = fileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), suffix, null);
            String path = storePath.getFullPath();
            entity.setCoverPic(preUrl + path);
            entity.setName(filename);
            entity.setSort(1);
            this.baseMapper.insert(entity);
            return ResultBean.success(path);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultBean.failed(e.getMessage());
        }
    }
}
