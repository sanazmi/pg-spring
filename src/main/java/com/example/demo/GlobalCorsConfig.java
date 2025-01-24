package com.example.demo;

// package com.example.password_generator;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOrigins("http://localhost:8081") // Add the origin of your frontend
//                 .allowedMethods("GET", "POST")
//                 .allowedHeaders("*");
//     }
// }




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
        config.addAllowedOrigin("http://localhost:8083");
        config.addAllowedOrigin("https://sanazmi.github.io");
        config.addAllowedOrigin("https://github.com/sanazmi/pg-spring");
        config.addAllowedOrigin("https://pg-spring-production.up.railway.app/");
        config.setAllowCredentials(true); 
        config.addAllowedMethod("*"); // Allow all methods
        config.addAllowedHeader("*"); // Allow all headers
        config.addExposedHeader("Access-Control-Allow-Origin");
        config.addExposedHeader("Access-Control-Allow-Credentials");
        config.setMaxAge(3600L); // Cache preflight response for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
