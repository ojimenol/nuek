package com.santander.san.merchant.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Creates the necessary objects to configure Springdoc OpenAPI. OpenAPI automates the
 * generation of API documentation using spring boot projects This class only will be
 * loaded with Non production profile.
 *
 * @author Santander Technology
 */
@Configuration(proxyBeanMethods = false)
public class SwaggerConfig {

  /**
   * Creates Springdoc object where the API Documentation is grouped by package and path
   * pattern
   *
   * @return GroupedOpenApi
   */
  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder().group("api-web").packagesToScan("com.santander.san.merchant.web")
      .addOpenApiCustomizer(this.customerGlobalHeaderOpenApiCustomiser()).build();
  }

  /**
   * Creates Springdoc object where it is defined or described the API definition.
   *
   * @return OpenAPI
   */
  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info()
        .title("merchantPortal")
        .description("merchantPortal")
        .version("1.0.0-SNAPSHOT"))
      .components(new Components().addSecuritySchemes("BearerAuth",
        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
      .addSecurityItem(new SecurityRequirement().addList("BearerAuth"));
  }

  /**
   * Add all default architecture headers
   *
   * @return OpenApiCustomizer
   */
  public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
    // Arq headers. Explain in
    // https://confluence.ci.gsnet.corp/pages/viewpage.action?pageId=213326163
    return (OpenAPI openApi) -> {
      openApi.components(addCommonParameters(openApi.getComponents()));
    };
  }

  /**
   * Add commons parameters in OpeApi.
   *
   * @param comp components
   * @return components
   */
  private static Components addCommonParameters(Components comp) {
    return comp.addParameters("x-santander-client-id",
      new HeaderParameter().required(Boolean.FALSE).name("x-santander-client-id")
        .description("""
          Identify the calling application.
          It originates from the client that calls an API, either a presentation
          component or a microservice.
          """)
        .schema(new StringSchema()).example("darwin"));
  }


}
