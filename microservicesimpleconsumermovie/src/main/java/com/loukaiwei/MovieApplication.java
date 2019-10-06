package com.loukaiwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class MovieApplication {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate_fangwenqi()
//    {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
