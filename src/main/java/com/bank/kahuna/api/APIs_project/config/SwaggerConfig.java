package com.bank.kahuna.api.APIs_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bank.kahuna.api.APIs"))
                .paths(regex("/bank.*"))
                .build()
                .apiInfo(info());
    }

    private ApiInfo info() {
      ApiInfo info = new ApiInfo(
          "REST API for the kahuna bank",
          "Swagger API for the kahuna bank web app",
          "1.0",
          "Terms of Service",
          "Mofokeng Mpho Alphios (alphios988@gmail.com)",
          "Apache License 2.0",
          "https://www.apache.org/license.html"
      );
      return  info;
    }
}
