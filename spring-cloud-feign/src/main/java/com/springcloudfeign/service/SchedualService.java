package com.springcloudfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign中使用断路器，只需在@FeignClient()注解中添加 fallback 属性即可
 * @author zlj
 */
@FeignClient(value = "eureka-client-hello", fallback = SchedualServiceHihystrix.class)
public interface SchedualService {

    @GetMapping("/test/eurekaClient")
    String schedualSayHello(@RequestParam("name") String name);
}
