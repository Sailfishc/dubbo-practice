package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/5 12:04 上午
 */
//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "Thrift";
    }
}
