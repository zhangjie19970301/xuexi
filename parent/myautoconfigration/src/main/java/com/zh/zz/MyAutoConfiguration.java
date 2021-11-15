package com.zh.zz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyAutoProperties.class)
public class MyAutoConfiguration {
    @Autowired
    MyAutoProperties myAutoProperties;


    @Bean
    public GetPropertiesService getPropertiesService(){
        GetPropertiesService service=new GetPropertiesService();
        service.setMyAutoProperties(myAutoProperties);
        return service;
    }










}




