package com.loukaiwei;

import org.springframework.stereotype.Component;

@Component
public class FallbackClient implements UserFeignClient1 {
    @Override
    public User find(Long id) {
        return UserBuilder.anUser().withUsername("DefaultUser").build();
    }


}
