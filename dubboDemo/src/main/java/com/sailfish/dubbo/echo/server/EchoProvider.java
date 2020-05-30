package com.sailfish.dubbo.echo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.echo
 * @Description:
 * @date 2020/5/30 8:48 上午
 */
public class EchoProvider {


    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo/spring-dubbo-server.xml"});
        context.start();

        System.in.read();
    }
}
