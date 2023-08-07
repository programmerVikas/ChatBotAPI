///*
// * Copyright (C) 2021 TechnoJade Solutions
// */
//package com.technojade.allybot.config;
//
//import java.util.Arrays;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * @author Babban
// *
// */
//
//@Configuration
//public class MyCorsConfig {
//
//	@Bean
//	public FilterRegistrationBean corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
////		config.setAllowedOrigins(
////                Arrays.asList(
////                        "https://143.110.242.247",
////                        "http://143.110.242.247:8084",
////                        "http://localhost:3000","https://localhost:3000", "http://localhost:8085", "http://localhost:8085"));
////		//config.addAllowedHeader("*");
////		config.addAllowedMethod("GET");
////		config.addAllowedMethod("POST");
////		config.addaddAllowedMethodAllowedMethod("PUT");
////		config.("DELETE");
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//		bean.setOrder(0);
//		return bean;
//	}
//}
