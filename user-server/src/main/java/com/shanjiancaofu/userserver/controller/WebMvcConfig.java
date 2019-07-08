package com.shanjiancaofu.userserver.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其他静态资源，与本文关系不大
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + "upload/");

        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
    }
}