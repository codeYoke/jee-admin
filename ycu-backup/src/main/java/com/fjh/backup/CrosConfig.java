package com.fjh.backup;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许跨域
                .allowedOrigins("*")//运行跨域的源
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE") //允许请求的方法
                .maxAge(16800)//间隔时间
                .allowedHeaders("*")//允许头部设置
                .allowCredentials(true);//允许发送cookie
    }
}
