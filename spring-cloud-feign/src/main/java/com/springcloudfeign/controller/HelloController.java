package com.springcloudfeign.controller;

import com.springcloudfeign.service.SchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlj
 */
@RestController
public class HelloController {

    @Autowired
    SchedualService schedualService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam("name") String name) {
        return schedualService.schedualSayHello(name);
    }
}
