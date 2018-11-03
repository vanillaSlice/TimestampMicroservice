package lowe.mike.timestampapp.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger config.
 *
 * @author Mike Lowe
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * TODO.
   *
   * @return TODO
   */
  @Bean
  public Docket produceApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("lowe.mike.timestampapp.controller"))
        .paths(paths())
        .build()
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Timestamp App Rest APIs")
        .description("This page lists all the rest apis for the Timestamp App.")
        .version("1.0.0")
        .license("MIT")
        .licenseUrl("https://github.com/vanillaSlice/TimestampMicroservice/blob/master/LICENSE")
        .build();
  }

  // Only select apis that matches the given Predicates.
  private Predicate<String> paths() {
    // Match all paths except /error
    return Predicates.and(
        PathSelectors.regex("/convert.*"),
        Predicates.not(PathSelectors.regex("/error.*")));
  }

}
