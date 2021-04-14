package com.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 1、@EnableConfigServer : 注解开启配置服务器的功能
 *
 * 2、从git仓库读取配置文件中的值到配置中心
 *
 * @author zlj
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
    }
}
