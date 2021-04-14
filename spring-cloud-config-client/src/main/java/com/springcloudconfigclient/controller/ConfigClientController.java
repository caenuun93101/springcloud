package com.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlj
 */
@RestController
public class ConfigClientController {

    @Value("${myName}")
    String myName;

    @Value("${foo}")
    String foo;

    /**
     * 从配置中心读取变量的值并返回
     * @return
     */
    @GetMapping("/getName")
    public String getMyName() {
        return myName;
    }

    @GetMapping("/foo")
    public String getFoo() {
        return foo;
    }
}
