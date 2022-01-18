package com.nekochanoide.univerSpringSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("main/index");
        registry.addRedirectViewController("/", "/parents");
        registry.addViewController("/doc").setViewName("main/doc");
        registry.addViewController("/login").setViewName("login");
    }
}
