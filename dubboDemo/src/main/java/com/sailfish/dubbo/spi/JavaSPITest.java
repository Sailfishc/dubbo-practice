package com.sailfish.dubbo.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author sailfish
 * @create 2019-08-07-16:12
 */
public class JavaSPITest {


    @Test
    public void test_java_spi() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
