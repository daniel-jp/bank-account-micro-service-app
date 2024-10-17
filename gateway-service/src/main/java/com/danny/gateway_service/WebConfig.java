package com.danny.gateway_service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;

@Configuration
public class WebConfig {


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Substitua pelo seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
