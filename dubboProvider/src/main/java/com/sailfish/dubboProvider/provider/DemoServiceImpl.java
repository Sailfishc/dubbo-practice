package com.sailfish.dubboProvider.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.sailfish.dubboApi.DemoService;

import java.util.Date;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}