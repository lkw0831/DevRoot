package com.loukaiwei;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 针对同一个微服务名，只能能有一个feign 客户端的定义接口，如果这个feignclient的value设置为user-service，那么就会和
 * UserFeignClient1的定义冲突，导致启动失败
 */
@FeignClient(value = "user-service1", path = "/level1/level2/level3", fallback = FallbackClient2.class)
public interface UserFeignClient2 {


    @PostMapping("/postAction")
    void Post(@RequestBody User user);

}
