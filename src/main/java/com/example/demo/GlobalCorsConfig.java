// package com.example.demo;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;

// @Configuration
// public class GlobalCorsConfig {

//     @Bean
//     public CorsFilter corsFilter() {
//         CorsConfiguration config = new CorsConfiguration();
//         config.addAllowedOrigin("http://localhost:8083"); // Localhost
//         config.addAllowedOrigin("https://github.com/sanazmi"); // GitHub Pages
//         config.addAllowedOrigin("https://pg-spring-production.up.railway.app"); // Railway

//         config.setAllowCredentials(true); // Allow cookies/authentication
//         config.addAllowedMethod("*"); // Allow all HTTP methods
//         config.addAllowedHeader("*"); // Allow all headers
//         config.setMaxAge(3600L); // Cache preflight response for 1 hour

//         // Register configuration for all routes
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", config);
//         return new CorsFilter(source);
//     }
// }


package com.example.demo;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(
            List.of("http://localhost:8083", "https://github.com/sanazmi", "https://pg-spring-production.up.railway.app")
        ); // Using setAllowedOrigins instead of multiple addAllowedOrigin
        config.setAllowCredentials(true); // Allow cookies/authentication
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        config.setMaxAge(3600L); // Cache preflight response for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
