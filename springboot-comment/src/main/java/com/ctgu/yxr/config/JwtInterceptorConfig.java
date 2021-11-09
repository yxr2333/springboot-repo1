package com.ctgu.yxr.config;

import com.ctgu.yxr.service.impl.JwtAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JwtInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * @addPathPatterns 配置拦截的路径
         * 如果写成 .addPathPatterns("/**")
         * 那么就会拦截所有的controller
         **/
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/comment");
    }
    @Bean
    public JwtAuthenticationInterceptor authenticationInterceptor() {
        return new JwtAuthenticationInterceptor();
    }
}

