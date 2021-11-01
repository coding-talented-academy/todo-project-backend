package todo.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .directModelSubstitute(Object.class, Void.class)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("todo.project"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("TODO API")
        .description("TODO API 명세입니다.")
        .license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .version("1.0")
        .build();
  }
}
