package com.example.APICSharp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.example.APICSharp.Utils.Constants.APP_ROOT;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("APICSharp Documentation")
                                .title("REST API")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.APICSharp"))
                .paths(PathSelectors.ant(APP_ROOT+ "/**"))
                .build();
    }
}
