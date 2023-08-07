/*
 * Copyright (C) 2021 TechnoJade Solutions
 */
package com.technojade.allybot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Babban
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.technojade.allybot.enpoint")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("TechnoJade Admin API", "These API's will provide Admin functionality to TjConnect.",
				"API TOS", "", new Contact("TechnoJade", "https://technojade.com/", "info@technojade.com"), "", "",
				Collections.emptyList());
	}
}