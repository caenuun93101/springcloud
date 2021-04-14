package com.springcloudribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @HystrixCommand(fallbackMethod="hiError"): 该注解对该方法创建了断路器的功能，
     * 并指定了fallbackMethod方法，该方法直接返回了一个字符串
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod="hiError")
    public String hello(String name) {
        return restTemplate.getForObject("Http://EUREKA-CLIENT-HELLO/test/eurekaClient?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hiError: " + name;
    }
}
