package com.sailfish.dubboProvider.provider;

import java.util.Date;

import com.sailfish.dubboApi.DemoService;

import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}