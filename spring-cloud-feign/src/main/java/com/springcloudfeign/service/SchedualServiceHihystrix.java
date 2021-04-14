package com.springcloudfeign.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHihystrix implements SchedualService{

    @Override
    public String schedualSayHello(String name) {
        return "sorry, " + name;
    }
}
