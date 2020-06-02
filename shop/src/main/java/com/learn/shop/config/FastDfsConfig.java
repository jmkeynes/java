package com.learn.shop.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/2 19:36
 * @ClassName FastDFSConfig
 */
@Configuration
@Import(FdfsClientConfig.class)
public class FastDfsConfig {
}
