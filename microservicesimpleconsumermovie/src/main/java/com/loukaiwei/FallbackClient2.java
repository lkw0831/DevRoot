package com.loukaiwei;

import org.springframework.stereotype.Component;

@Component
public class FallbackClient2 implements UserFeignClient2 {

    @Override
    public void Post(User user) {
        System.out.println("降级的POST请求");
    }
}
