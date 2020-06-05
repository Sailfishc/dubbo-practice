package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 参考博客： https://www.jianshu.com/p/dc616814ce98
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/5 12:06 上午
 */
public class AdaptiveExt2Test {


    // 测试一：SPI注解中有value值
    @Test
    public void echo() {

        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }


    // 测试二：SPI注解中有value值，URL中也有具体的值
    @Test
    public void SpiHasDubboAndURLHasSpring() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2=spring");
        System.out.println(adaptiveExtension.echo("d", url));
    }


    // 测试三：SPI注解中有value值，URL中也有具体的值,实现类上有@Adaptive注解
    // TODO: 2020/6/5 需要在  ThriftAdaptiveExt2 加上 Adaptive注解
    @Test
    public void SPI_Has_dubbo_But_Thrift_Has_Adaptive() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }


    // 测试四：SPI注解中有value值,实现类上没有@Adaptive注解，在方法上打上@Adaptive注解，注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name,获取相应的实现类。

    @Test
    public void SPI_HAS_DUBBO_AND_Adaptive_Has_Spring() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?t=spring");
        System.out.println(adaptiveExtension.echo("d", url));
    }
}