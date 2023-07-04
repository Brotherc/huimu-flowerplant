package com.huimu.flowerplant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder tokenPar = new RequestParameterBuilder();
        tokenPar.name("userId")
                .description("用户token")
                .in(ParameterType.HEADER)
                .query(q -> q
                        .model(modelSpecificationBuilder -> modelSpecificationBuilder.scalarModel(ScalarType.STRING))
                        .defaultValue("1")
                )
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                // 只显示非admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.huimu.flowerplant"))
                .paths(PathSelectors.regex("^(?!/admin).*"))
                .build()
                .globalRequestParameters(pars);
    }

    @Bean
    public Docket adminApiConfig() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder tokenPar = new RequestParameterBuilder();
        tokenPar.name("adminId")
                .description("用户token")
                .in(ParameterType.HEADER)
                .query(q -> q
                        .model(modelSpecificationBuilder -> modelSpecificationBuilder.scalarModel(ScalarType.STRING))
                        .defaultValue("1")
                )
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                // 只显示admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.huimu.flowerplant"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                .globalRequestParameters(pars);
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了卉沐花植接口定义")
                .version("1.0")
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了卉沐花植后台系统服务接口定义")
                .version("1.0")
                .build();
    }

}
