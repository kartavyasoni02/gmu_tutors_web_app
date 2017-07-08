package com.gmu.tutors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocumentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration("");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "GMU Tutors Application",
                "Web App project to connect students to their peer tutors",
                "0.0.1",
                "",
                new Contact("Andrew Huynh", "https://github.com/SaxyPandaBear", "ahuynh11@gmu.edu"),
                "MIT",
                "",
                null
        );
    }
}
