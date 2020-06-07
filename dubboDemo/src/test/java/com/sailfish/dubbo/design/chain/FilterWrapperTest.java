package com.sailfish.dubbo.design.chain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.design.chain
 * @Description:
 * @date 2020/6/7 10:30 上午
 */
public class FilterWrapperTest {

    @Test
    public void buildInvokerChain() {
        Invoker invoker = new InvokerImpl();
        FilterWrapper.buildInvokerChain(invoker);

    }
}