package com.sailfish.dubbo.remoting;

import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.Exchangers;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.remoting
 * @Description:
 * @date 2020/6/7 12:43 下午
 */
public class ServerDemo {


    public static void main(String[] args) throws RemotingException {
        String url = "dubbo://192.168.123.165:20880/com.sailfish.dubbo.echo.EchoService?anyhost=true&application=echo-provider&bean.name=com.sailfish.dubbo.echo.EchoService&bind.ip=192.168.123.165&bind.port=20880&dubbo=2.0.2&generic=false&interface=com.sailfish.dubbo.echo.EchoService&methods=echo&pid=41414&qos.port=22222&side=provider&timestamp=1591504906837";
        Exchangers.bind(url, new ExchangeHandlerAdapter());
    }

}

