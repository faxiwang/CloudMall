package com.faxi.cloudmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @date 2021-07-19 21:25
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();
        // 允许所有请求头跨域
        corsConfig.addAllowedHeader("*");
        // 允许所有请求方式跨域
        corsConfig.addAllowedMethod("*");
        // 允许所有请来源跨域
        corsConfig.addAllowedOriginPattern("*");
        // 是否允许携带cookie跨域
        corsConfig.setAllowCredentials(true);
        source.registerCorsConfiguration("/**",corsConfig);
        return new CorsWebFilter(source);
    }
}
