package com.loukaiwei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate_fangwenqi;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient1 userFeignClient1;

    @Autowired
    private UserFeignClient2 userFeignClient2;

//    @Value("${user.service-url}")
//    private String url;

    //@HystrixCommand(fallbackMethod = "findByIdFallBack")
    @GetMapping("/user/{userId}")
    public User findByid(@PathVariable Long userId) {
        //User found = restTemplate_fangwenqi.getForObject("http://user-service/level1/level2/level3/" + userId, User.class);
        //User found = restTemplate_fangwenqi.getForObject(url + userId, User.class);
        User found = userFeignClient1.find(userId);
        LOGGER.info("当前电影微服务实例被调用");
        return found;
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> t = this.discoveryClient.getInstances("");
        return t;
    }

    /**
     * 发起Rest请求的feign代码可以写的和响应方几乎一样
     */
    @GetMapping("/GetIndeedPost")
    public void getIndeedPost() {
        User user = new User();
        user.setAge(36);
        user.setMyname("楼凯娃娃");
        user.setUsername("UUUUU");
        BigDecimal bigDecimal = new BigDecimal(1000000);
        //user.setBalance(bigDecimal);
        userFeignClient2.Post(user);
    }

    @GetMapping("/log-instance")
    public ServiceInstance checkLoadBalance() {
        ServiceInstance instance = loadBalancerClient.choose("user-service");
        LOGGER.info(instance.getServiceId() + "   " + instance.getHost() + "   " + instance.getPort());
        return instance;
    }


    public User findByIdFallBack(Long userId) {
        return UserBuilder.anUser().withAge(10).withBalance(new BigDecimal(10)).withMyname("default").withUsername("default").build();
    }

}
