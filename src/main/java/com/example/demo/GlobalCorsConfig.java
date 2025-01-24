package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// @Configuration
// public class GlobalCorsConfig {

//     @Bean
//     public CorsFilter corsFilter() {
//         CorsConfiguration config = new CorsConfiguration();
//         config.addAllowedOrigin("http://localhost:8083"); // Local development frontend
//         config.addAllowedOrigin("https://sanazmi.github.io"); // GitHub Pages frontend
//         config.setAllowCredentials(true); // Allow cookies/auth headers if needed
//         config.addAllowedMethod("*"); // Allow all HTTP methods
//         config.addAllowedHeader("*"); // Allow all request headers

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", config); // Apply to all endpoints
//         return new CorsFilter(source);
//     }
// }

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8083"); // Localhost
        config.addAllowedOrigin("https://github.com/sanazmi"); // GitHub Pages
        config.addAllowedOrigin("http://pg-spring-production.up.railway.app"); // Railway

        config.setAllowCredentials(true); // Allow cookies/authentication
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        config.setMaxAge(3600L); // Cache preflight response for 1 hour

        // Register configuration for all routes
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
