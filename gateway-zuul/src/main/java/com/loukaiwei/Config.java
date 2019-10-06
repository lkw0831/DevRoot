package com.loukaiwei;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public PreRequestLogFilter name_is_not_important_what_ever_it_is() {
        return new PreRequestLogFilter();
    }

    @Bean
    public MovieFallbackProvider abcdefgHiljflajflajl() {
        return new MovieFallbackProvider();
    }

    @Bean
    @LoadBalanced
    public RestTemplate wedontcarethename() {
        return new RestTemplate();
    }
}
