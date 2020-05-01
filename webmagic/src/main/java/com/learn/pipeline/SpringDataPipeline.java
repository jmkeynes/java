package com.learn.pipeline;

import com.learn.entity.JobInfoEntity;
import com.learn.service.IJobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:39
 * 版本： 1.0
 */
@Component
public class SpringDataPipeline implements Pipeline {

    private static final String JOBINFO = "jobInfo";

    @Autowired
    private IJobInfoService jobInfoService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        //获取需要保存的数据
        JobInfoEntity entity = resultItems.get(JOBINFO);

        //判断数据不为空
        if (entity != null) {
            this.jobInfoService.save(entity);
        }
    }
}
