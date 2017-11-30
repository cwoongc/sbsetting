package com.cwoongc.sbsetting.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
//@EnableWebMvc
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
public class WebMvcConfig extends WebMvcConfigurationSupport {

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//
//        converter.setGson(gson);
//
//        converters.add(converter);
//    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

    }

}
