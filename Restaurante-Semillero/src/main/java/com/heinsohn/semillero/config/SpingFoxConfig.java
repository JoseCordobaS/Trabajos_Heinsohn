package com.heinsohn.semillero.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpingFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.build().apiInfo(getInfoApi());
	}
	
	private ApiInfo getInfoApi() {
		return new ApiInfo("API servicios para los usuarios",
				"Este api permite usar el crud para los usuarios de la aplicacion", 
				"1.0.0", "https://heinsohn.com.co",
				new Contact("José Córdoba","https://heinsohn.com.co","josemaprosk8@gmail.com"),
				"License","https://heinsohn.com.co/license",Collections.emptyList());
	}
	
	
	
	
}
