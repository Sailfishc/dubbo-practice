package com.sailfish.dubbo.echo.server;

import com.sailfish.dubbo.echo.EchoService;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.echo
 * @Description:
 * @date 2020/5/30 8:39 上午
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        System.out.println("Hello " + message);
        return message;
    }
}
