package com.example.demo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/log.html").setViewName("log");
        registry.addViewController("/log").setViewName("log");
        registry.addViewController("/userspace").setViewName("userspace");
        registry.addViewController("/userspace.html").setViewName("userspace");
        registry.addViewController("/memberspace.html").setViewName("memberspace");
        registry.addViewController("/memberspace").setViewName("memberspace");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandler())
                .addPathPatterns("/userspace")
                .addPathPatterns("/userspace.html")
                .addPathPatterns("/memberspace")
                .addPathPatterns("/memberspace.html")
                .addPathPatterns("/userspace").excludePathPatterns("/index.html","/","/user/login","/css/**","/doc/**","/font/**","/img/**","/js/**","/ref/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }
}
