package com.springcloudeurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlj
 */
@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/test/eurekaClient")
    public String sayHello(@RequestParam("name") String name) {
        return "hello : " + name + " , I am from port " + port;
    }
}
