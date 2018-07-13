package com.springboot.redis.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @ClassName: SwaggerConfiguration
 * @Description: 接口文档相关配置
 * @author S.J.
 * @date 2017年9月15日 上午10:39:02
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.redis"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("base microservice provider RESTful APIs")
                .description("数据上链基础服务接口")
                .termsOfServiceUrl("http://www.ochain.fun/")
                .contact(new Contact("S.J.", "http://www.ochain.fun/", "songjia@ochain.fun"))
                .version("1.0.0")
                .build();
    }
}
