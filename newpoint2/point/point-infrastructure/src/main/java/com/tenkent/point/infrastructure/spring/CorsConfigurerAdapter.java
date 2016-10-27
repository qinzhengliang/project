package com.tenkent.point.infrastructure.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 10115916 on 2016/7/13 0013.
 * 用于全局控制跨域访问设置
 */
@Configuration
public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedOrigins("*");
    }
}
