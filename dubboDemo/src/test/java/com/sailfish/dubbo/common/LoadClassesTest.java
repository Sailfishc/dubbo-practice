package com.sailfish.dubbo.common;

import com.sailfish.dubbo.extension.adaptive.AdaptiveExt2;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.common
 * @Description:
 * @date 2020/6/6 5:13 下午
 */
public class LoadClassesTest {

    @Test
    public void loadClasses() {
        LoadClasses loadClasses = new LoadClasses();
        final Map<String, Class<?>> classes = loadClasses.loadClasses(AdaptiveExt2.class);
        for (Map.Entry<String, Class<?>> entry : classes.entrySet()) {
            System.out.println("key = " + entry.getKey() + " -- value = " + entry.getValue());
        }
    }
}