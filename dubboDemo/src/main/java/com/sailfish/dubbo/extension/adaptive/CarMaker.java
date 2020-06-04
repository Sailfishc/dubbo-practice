package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/6/3 5:05 下午
 */
public interface CarMaker {

    Car makeCar(URL url);

}
