package com.loukaiwei;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-service", path = "/level1/level2/level3", fallback = FallbackClient.class)
public interface UserFeignClient1 {

    @GetMapping("/{id}")
    User find(@PathVariable("id") Long id);

}
