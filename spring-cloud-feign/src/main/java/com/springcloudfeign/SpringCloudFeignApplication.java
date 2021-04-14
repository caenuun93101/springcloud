package com.springcloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign中使用断路器
 *
 * 1、@EnableFeignClients : 开启feign 功能
 *
 * @author zlj
 */
@EnableFeignClients
@SpringBootApplication
public class SpringCloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignApplication.class, args);
    }
}
