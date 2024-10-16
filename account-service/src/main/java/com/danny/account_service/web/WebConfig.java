package com.danny.account_service.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class WebConfig {


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Substitua pelo seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
