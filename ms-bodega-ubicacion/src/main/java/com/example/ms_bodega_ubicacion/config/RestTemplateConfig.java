package com.example.ms_bodega_ubicacion.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    private static RestTemplate instance;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        if (instance == null) {
            instance = new RestTemplate();
        }
        return instance;
    }
}