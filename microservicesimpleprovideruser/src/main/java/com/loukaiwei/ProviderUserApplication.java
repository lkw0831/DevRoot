package com.loukaiwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.Console;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = {"com.loukaiwei"})
public class ProviderUserApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProviderUserApplication.class, args);
        System.out.println(ctx);
        String[] hrehr = ctx.getBeanDefinitionNames();
    }
}
