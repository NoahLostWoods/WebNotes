package utils;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .paths(null)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JavaInUse API")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl(null)
                .contact(new Contact("Valerio", "valerio.carcaterra@outlook.com", "valerio.carcaterra@outlook.com"))
                .license("JavaInUse License")
                .licenseUrl("valerio.carcaterra@outlook.com")
                .version("1.0")
                .build();
    }
}
