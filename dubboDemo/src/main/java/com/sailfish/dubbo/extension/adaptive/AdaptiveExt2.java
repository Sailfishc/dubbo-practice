package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/5 12:03 上午
 */
@SPI("dubbo")
public interface AdaptiveExt2 {

    @Adaptive(value = "{t}")
    String echo(String msg, URL url);
}
