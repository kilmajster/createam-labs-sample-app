package io.github.createam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Createam demo application")
                        .description("Api documentation of dummy app.\n")
                        .version("0.1")
                        .license("MIT").licenseUrl("https://raw.githubusercontent.com/createam-labs/spring-boot-starter-heroku/master/LICENSE")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.createam.web"))
                .paths(PathSelectors.any())
                .build();
    }

//    @SneakyThrows
//    private String fetchHerokuSpringStarterReadmeAsString() {
//        URL DescriptionUrl = new URL("https://raw.githubusercontent.com/createam-labs/spring-boot-starter-heroku/master/README.md");
//
//
//        return herokuReadme;
//    }
}
