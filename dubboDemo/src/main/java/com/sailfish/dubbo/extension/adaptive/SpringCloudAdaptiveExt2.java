package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/5 12:04 上午
 */
public class SpringCloudAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "spring";
    }
}
