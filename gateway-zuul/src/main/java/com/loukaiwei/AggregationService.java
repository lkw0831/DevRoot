package com.loukaiwei;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

/**
 * 此类是在网关中聚合业务逻辑的代码，不应该这么做
 */
@Service
public class AggregationService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackFunc")
    public Observable<User> getUserById(Long id) {
        return Observable.create(observer -> {
            User user = restTemplate.getForObject("http://user-service/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallbackFunc")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(observer -> {
            User user = restTemplate.getForObject("http://movie-service/user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    public User fallbackFunc(Long id) {
        User defaultU = new User();
        defaultU.setId(-1l);
        defaultU.setUserName("default Name");
        return defaultU;
    }

}
