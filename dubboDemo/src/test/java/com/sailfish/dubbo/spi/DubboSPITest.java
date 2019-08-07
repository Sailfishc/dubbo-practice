package com.sailfish.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * Dubbo SPI模拟：需要在Robot中添加@SPI注解
 * @author sailfish
 * @create 2019-08-07-16:12
 */
public class DubboSPITest {


    @Test
    public void test_java_spi() {

        ExtensionLoader<Robot> loader = ExtensionLoader.getExtensionLoader(Robot.class);

        final Robot optimusPrime = loader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        final Robot bumblebee = loader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
