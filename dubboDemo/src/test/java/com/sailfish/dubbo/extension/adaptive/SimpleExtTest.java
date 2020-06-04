package com.sailfish.dubbo.extension.adaptive;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.extension.adaptive
 * @Description:
 * @date 2020/5/31 12:35 下午
 */
public class SimpleExtTest {

    @Test
    public void echo() {

        final SimpleExt adaptiveExtension = ExtensionLoader.getExtensionLoader(SimpleExt.class).getAdaptiveExtension();   // simpleExt$Adaptive

    }
}