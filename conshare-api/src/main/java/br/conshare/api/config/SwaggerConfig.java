package br.conshare.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration

public class SwaggerConfig {
	
	@Value("${swagger.enabled}")
	private boolean swaggerEnabled;
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.conshare.api.controller")).paths(PathSelectors.any())
				.build().apiInfo(getAppInfo()).enable(swaggerEnabled);
	}

	private ApiInfo getAppInfo() {

		return new ApiInfoBuilder().title("BR - CONSHARE - API").description("API do projeto").version("1.0").build();
	}

}
