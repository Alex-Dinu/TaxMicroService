package com.alex.tax.config;

import com.alex.tax.interceptors.TaxServiceInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class TaxServiceInterceptorAppConfig implements WebMvcConfigurer {
    @Autowired
    TaxServiceInterceptor taxServiceInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(taxServiceInterceptor);
    }
 }