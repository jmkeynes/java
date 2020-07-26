package com.learn.jwt.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作者： jwp
 * 创建时间： 2020/7/25 17:34
 * 描述：Knife4jConfig
 */
@EnableSwagger2
@Configuration
@EnableKnife4j
public class Knife4jConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learn.jwt.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DBCluster Knife4j")
                .version("1.0")
                .termsOfServiceUrl("http://localhost:8888/doc.html#/home")
                .description("多数据源自动切换+knife4j文档的使用学习")
                .build();
    }
}
