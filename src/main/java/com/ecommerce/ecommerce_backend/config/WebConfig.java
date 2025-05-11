package com.ecommerce.ecommerce_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // This assumes uploaded_images/ is in the root where the app is started
        registry.addResourceHandler("/uploaded_images/**")
                .addResourceLocations("file:uploaded_images/");
    }
}
