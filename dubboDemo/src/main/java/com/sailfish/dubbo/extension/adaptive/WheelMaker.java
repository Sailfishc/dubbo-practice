package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/3 4:22 下午
 */
public interface WheelMaker {

    Wheel makeWheel(URL url);

}
