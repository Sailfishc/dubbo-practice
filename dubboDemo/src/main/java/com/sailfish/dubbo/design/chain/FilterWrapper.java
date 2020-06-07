package com.sailfish.dubbo.design.chain;


import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.design.chain
 * @Description:
 * @date 2020/6/7 10:22 上午
 */
public class FilterWrapper {


    /**
     * 构造InvokerChain
     *
     * @param invoker
     * @param key
     * @param group
     * @param <T>
     * @return
     */
    public static <T> Invoker<T> buildInvokerChain(final Invoker<T> invoker) {
        Invoker<T> last = invoker;
        List<Filter> filters = Lists.newArrayList(new AFilter(), new BFilter());
        if (!filters.isEmpty()) {
            for (int i = filters.size() - 1; i >= 0; i--) {
                final Filter filter = filters.get(i);
                final Invoker<T> next = last;
                last = new Invoker<T>() {

                    @Override
                    public Result invoke(Invocation invocation) throws RpcException {
                        return filter.invoke(next, invocation);
                    }

                    @Override
                    public String toString() {
                        return invoker.toString();
                    }
                };
            }
        }

        return last;
    }
    
    
}
