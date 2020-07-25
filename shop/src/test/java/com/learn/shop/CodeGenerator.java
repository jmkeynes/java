package com.learn.shop;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author 江文谱
 * @version 1.0
 * @date 2020/6/1 15:10
 * @ClassName ss
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
// 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        //代码生成文件夹
        gc.setOutputDir("D:\\developer\\code\\shop\\src\\main\\java");
        //创建者
        gc.setAuthor("江文谱");
        //是否打卡输出文件   默认true
        gc.setOpen(false);
        //Id属性自增
        gc.setIdType(IdType.INPUT);
        //是否重写文件 默认false
        gc.setFileOverride(true);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        // controller层的名称
        gc.setControllerName("%sController");
        //dao层的名称
        gc.setMapperName("%sDao");
        //映射文件的名称
        gc.setXmlName("%sMapper");
        //服务层的名称
        gc.setServiceName("I%sService");
        //服务层的实现类名称
        gc.setServiceImplName("%sServiceImpl");
        gc.setEntityName("%sEntity");
        // 设置生产结果映射map
        gc.setBaseResultMap(true);
        // 设置生产查询结果列
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.249.133/mall?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setController("com.learn.databases_cluster.controller");
        pc.setEntity("com.learn.databases_cluster.entity");
        pc.setMapper("com.learn.databases_cluster.dao");
        pc.setService("com.learn.databases_cluster.service");
        pc.setServiceImpl("com.learn.databases_cluster.service.impl");
        pc.setXml("mapper");
        pc.setParent("com.learn.shop");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        mpg.setCfg(cfg);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体类的命名策略，未指定按照maning执行
        strategy.setColumnNaming(NamingStrategy.no_change);
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //是否生成实体时，生成字段注解
//		strategy.setTablePrefix(pc.getModuleName() + "_");

        //实体类是否为Lombok模型  默认false
        strategy.setEntityLombokModel(true);
        //需要包含的表名，运行正则表达式
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        mpg.setStrategy(strategy);
        mpg.execute();

    }

}
