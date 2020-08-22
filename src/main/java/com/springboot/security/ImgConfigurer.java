package com.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置图片映射路径
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\WorkSpace\\SpringbootWorkspace\\securitydemo\\src\\main\\resources\\static\\images\\");
    }
}