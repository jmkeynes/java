package com.learn.schedule;

import com.learn.entity.JobInfoEntity;
import com.learn.pipeline.SpringDataPipeline;
import com.learn.utils.MathSalary;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建人：江文谱
 * 创建时间： 2020/4/30 21:36
 * 版本： 1.0
 */
@Component
public class JobProcessor implements PageProcessor {

    @Value("${webMagic.url}")
    private String url;

    private static final String selectTable = "div#resultList div.el";

    private static final String hyperlink = "div.p_in li.bk";

    @Autowired
    private SpringDataPipeline pipeline;

    /**
     * 爬虫配置
     */
    private Site site = Site
            .me()
            //设置超时时间
            .setTimeOut(1000 * 10)
            //设置抓取间隔
            .setSleepTime(1)
            //设置字符编码
//            .setCharset("UTF-8")
            .setCharset("GBK")
            //设置重试时间
            .setRetrySleepTime(3000)
            //设置重试次数
            .setRetryTimes(3);


    @Override
    public void process(Page page) {

        //获取页面数据
        List<Selectable> nodes = page.getHtml().$(selectTable).nodes();

        //判断nodes是否为空
        if (nodes.isEmpty()) {
            try {
                //保存信息
                this.saveJobInfo(page);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //如果有值,则遍历招聘信息列表
            nodes.forEach(node -> {
                //获取招聘信息详情页url
                String subUrl = node.links().toString();

                //添加到url任务列表中,等待下载
                page.addTargetRequest(subUrl);

                //获取翻页按钮的超链接
                List<String> hyperlinks = page.getHtml().$(hyperlink).links().all();

                //添加到任务列表中
                page.addTargetRequests(hyperlinks);

            });
        }
    }

    private void saveJobInfo(Page page) {
        Html html = page.getHtml();
        JobInfoEntity jobInfo = new JobInfoEntity();
        //公司名称
        jobInfo.setCompanyName(html.$("div.tHeader p.cname a", "text").toString());
        //公司地址
        jobInfo.setCompanyAddr(html.$("div.tBorderTop_box > div.bmsg > p.fp", "text").toString());
        //公司信息
        jobInfo.setCompanyInfo(html.$("div.tmsg", "text").toString());
        //职位名称
        jobInfo.setJobName(html.$("div.tHeader > div.in > div.cn > h1", "text").toString());
        //工作地点
        jobInfo.setJobAddr(jobInfo.getCompanyAddr());
        //职位信息
        String toString = html.$("div.tBorderTop_box>div.bmsg", "html").toString();
        String jobDate = Jsoup.parse(html.$("div.tBorderTop_box>div.bmsg").toString()).text();
        if (StringUtils.isNotBlank(jobDate)) {
            jobInfo.setJobInfo(jobDate);
        }
        //工资范围
        String salaryStr = html.$("div.tHeader > div.in > div.cn > strong", "text").toString();
        if (StringUtils.isNotBlank(salaryStr)) {
            jobInfo.setSalaryMin(MathSalary.getSalary(salaryStr)[0]);
            jobInfo.setSalaryMax(MathSalary.getSalary(salaryStr)[1]);
        }
        //职位详情url
        jobInfo.setUrl(page.getUrl().toString());
        //职位发布时间
        String time = html.$("div.tHeader > div.in > div.cn > p.msg", "text").regex(".*发布").toString();
        String release = time.substring(time.length() - 7, time.length() - 2);
        jobInfo.setTime(release);

        //保存数据
        page.putField("jobInfo", jobInfo);
    }

    /**
     * 核心线程数
     */
    private int corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * 自定义线程池
     */
    private ExecutorService executor = new ThreadPoolExecutor(
            corePoolSize, corePoolSize * 2, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000)
    );

    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 100)
    public void process() {
        Spider.create(new JobProcessor())
                .addUrl(url)
                .addPipeline(this.pipeline)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                .thread(executor, corePoolSize)
                .run();
    }

    @Override
    public Site getSite() {
        return this.site;
    }
}
