package com.sailfish.dubbo.spi;

/**
 * @author sailfish
 * @create 2019-08-07-16:10
 */
public class Bumblebee implements Robot{

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
