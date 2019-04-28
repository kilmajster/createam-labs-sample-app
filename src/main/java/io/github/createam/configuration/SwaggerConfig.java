package io.github.createam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("\uD83D\uDD79 Demo application")
                        .description("Https enforcing works! Success! \uD83D\uDC4C\n\n" + "![That's funny \uD83D\uDE02](https://media.giphy.com/media/JOi0IO9ByxIHK/giphy.gif)")
                        .build()
                ).useDefaultResponseMessages(false)
                .protocols(Collections.singleton("https"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.createam.web"))
                .paths(PathSelectors.any())
                .build();
    }
}
