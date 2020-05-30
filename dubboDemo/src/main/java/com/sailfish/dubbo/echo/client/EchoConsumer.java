package com.sailfish.dubbo.echo.client;

import com.sailfish.dubbo.echo.EchoService;
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
public class EchoConsumer {


    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo/spring-dubbo-client.xml"});
        context.start();

        final EchoService echoService = (EchoService) context.getBean("echoService");
        final String status = echoService.echo("Hello Sailfish");
        System.out.println(status);
    }
}
