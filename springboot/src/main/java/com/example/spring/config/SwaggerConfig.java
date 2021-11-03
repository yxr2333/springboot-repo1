package com.example.spring.config;

/**
 * Created by Intellij IDEA
 *
 * @Author: Xinrui Yu
 * @Date: Created in 11:22 2021/11/3
 */
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    Boolean swaggerEnabled = true;
    @Bean
    public Docket createRestApi() {
        //http://ip地址:端口/项目名/swagger-ui.html#/
        ApiInfo apiInfo = new ApiInfoBuilder()
                //网站标题
                .title("学业帮扶后端")
                //网站描述
                .description("Swagger for SpringBoot")
                //版本
                .version("1.0")
                //联系人
                .contact(new Contact("yxr","https://yuque.iloveyxr.top","54535282@qq.com"))
                .build();
        //swagger版本
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                //扫描那些controller
                .apis(RequestHandlerSelectors.basePackage("com.example.spring.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }


}
