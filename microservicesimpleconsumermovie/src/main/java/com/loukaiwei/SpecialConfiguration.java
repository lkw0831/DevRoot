package com.loukaiwei;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpecialConfiguration {


    @LoadBalanced
    @Bean
    public RestTemplate test() {
        return new RestTemplate();
    }


//    @Bean
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
}
