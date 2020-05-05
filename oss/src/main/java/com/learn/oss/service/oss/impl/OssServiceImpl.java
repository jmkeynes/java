package com.learn.oss.service.oss.impl;

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.learn.oss.dto.oss.OssCallbackParam;
import com.learn.oss.pojo.oss.OssCallbackResult;
import com.learn.oss.pojo.oss.OssPolicyResult;
import com.learn.oss.service.oss.IOssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author：江文谱
 * @date： 2020/5/5 15:22
 * @version： 1.0
 */
@Service
public class OssServiceImpl implements IOssService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${aliyun.oss.policy.expire}")
    private int ALIYUN_OSS_EXPIRE;

    @Value("${aliyun.oss.maxSize}")
    private int ALIYUN_OSS_MAX_SIZE;

    @Value("${aliyun.oss.callback}")
    private String ALIYUN_OSS_CALLBACK;

    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKETNAME;

    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;

    @Value("${aliyun.oss.dir.prefix}")
    private String ALIYUN_OSS_DIR_PREFIX;


    @Autowired
    private OSSClient client;

    @Override
    public OssPolicyResult policy() {
        OssPolicyResult result = new OssPolicyResult();

        //存储目录
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dir = new StringBuilder().append(ALIYUN_OSS_DIR_PREFIX).append(format.format(new Date())).toString();

        //签名有效期
        long expireEndTime = System.currentTimeMillis() + ALIYUN_OSS_EXPIRE * 1000;
        Date expiration = new Date(expireEndTime);

        //文件大小
        long maxSize = ALIYUN_OSS_MAX_SIZE * 1024 * 1024;

        //回调
        OssCallbackParam param = new OssCallbackParam();
        param.setCallbackBody("filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
        param.setCallbackBodyType("application/x-www-form-urlencoded");
        param.setCallbackUrl(ALIYUN_OSS_CALLBACK);

        //提交节点
        String action = new StringBuilder().append("http").append(ALIYUN_OSS_BUCKETNAME).append(".").append(ALIYUN_OSS_ENDPOINT).toString();

        try {
            PolicyConditions conditions = new PolicyConditions();
            conditions.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
            conditions.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
            String postPolicy = client.generatePostPolicy(expiration, conditions);
            byte[] binaryDate = postPolicy.getBytes("utf-8");
            String policy = BinaryUtil.toBase64String(binaryDate);
            String signature = client.calculatePostSignature(postPolicy);
            String callbackData = BinaryUtil.toBase64String(JSONUtil.parse(param).toString().getBytes("utf-8"));

            //设置返回的结果
            result.setAccessKeyId(client.getCredentialsProvider().getCredentials().getAccessKeyId());
            result.setPolicy(policy);
            result.setSignature(signature);
            result.setDir(dir);
            result.setCallback(callbackData);
            result.setHost(action);
        } catch (Exception e) {
            LOGGER.warn("签名失败：{}", e.getMessage());
        }
        return result;
    }

    @Override
    public OssCallbackResult callback(HttpServletRequest request) {
        OssCallbackResult result = new OssCallbackResult();
        String filename = request.getParameter("filename");
        filename = "http".concat(ALIYUN_OSS_BUCKETNAME).concat(".").concat(ALIYUN_OSS_ENDPOINT).concat("/").concat(filename);
        result.setFilename(filename);
        result.setHeight(request.getParameter("height"));
        result.setWidth(request.getParameter("width"));
        result.setMimeType(request.getParameter("mineType"));
        result.setSize(request.getParameter("size"));
        return result;
    }
}
