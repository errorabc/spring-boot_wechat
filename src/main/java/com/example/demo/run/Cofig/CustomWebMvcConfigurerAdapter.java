package com.example.demo.run.Cofig;/*
   User: wuwen
   Date: 2018-03-16
   Time: 14-29
   备注：
    
    
    
 */

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import com.example.demo.run.Interceptor.LogInterceptor;
@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter  {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns("**.js","**.css");
    }
}
