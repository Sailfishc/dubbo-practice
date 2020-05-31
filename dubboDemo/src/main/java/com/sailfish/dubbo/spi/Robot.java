package com.sailfish.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * 测试JavaSPI
 * @author sailfish
 * @create 2019-08-07-16:10
 */
@SPI
public interface Robot {

    void sayHello();
}
