package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:  自适应类生成代码
 * @date 2020/5/31 12:34 下午
 */
@SPI("impl1")
public interface SimpleExt {

    @Adaptive
    String echo(URL url, String s);
}
