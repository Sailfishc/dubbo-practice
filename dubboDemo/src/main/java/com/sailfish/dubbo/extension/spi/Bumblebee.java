package com.sailfish.dubbo.extension.spi;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.spi
 * @Description:
 * @date 2020/5/31 12:31 下午
 */
public class Bumblebee implements Robot{

    @Override
    public void sayHello() {
        System.out.println("Hello Bumblebee");
    }
}
