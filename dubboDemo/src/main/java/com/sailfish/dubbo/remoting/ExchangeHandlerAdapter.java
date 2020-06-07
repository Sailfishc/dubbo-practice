package com.sailfish.dubbo.remoting;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.ExchangeChannel;
import com.alibaba.dubbo.remoting.exchange.ExchangeHandler;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcInvocation;

/**
 * @author 成易
 * @version V1.0
 * @Title:
 * @Package com.sailfish.dubbo.remoting
 * @Description:
 * @date 2020/6/7 12:45 下午
 */
public class ExchangeHandlerAdapter implements ExchangeHandler {

    @Override
    public Object reply(ExchangeChannel channel, Object message) throws RemotingException {
        if (message instanceof Invocation) {
            Invocation inv = (Invocation) message;
            boolean hasMethod = false;
            if (!hasMethod) {
                return null;
            }
        }
        return null;
    }


    @Override
    public void received(Channel channel, Object message) throws RemotingException {
        if (message instanceof Invocation) {
            reply((ExchangeChannel) channel, message);
        }
    }

    @Override
    public void connected(Channel channel) throws RemotingException {
        invoke(channel, Constants.ON_CONNECT_KEY);
    }

    @Override
    public void disconnected(Channel channel) throws RemotingException {
        invoke(channel, Constants.ON_DISCONNECT_KEY);
    }

    private void invoke(Channel channel, String methodKey) {
        Invocation invocation = createInvocation(channel, channel.getUrl(), methodKey);
        if (invocation != null) {
            try {
                received(channel, invocation);
            } catch (Throwable t) {
            }
        }
    }

    private Invocation createInvocation(Channel channel, URL url, String methodKey) {
        String method = url.getParameter(methodKey);
        if (method == null || method.length() == 0) {
            return null;
        }
        RpcInvocation invocation = new RpcInvocation(method, new Class<?>[0], new Object[0]);
        invocation.setAttachment(Constants.PATH_KEY, url.getPath());
        invocation.setAttachment(Constants.GROUP_KEY, url.getParameter(Constants.GROUP_KEY));
        invocation.setAttachment(Constants.INTERFACE_KEY, url.getParameter(Constants.INTERFACE_KEY));
        invocation.setAttachment(Constants.VERSION_KEY, url.getParameter(Constants.VERSION_KEY));
        if (url.getParameter(Constants.STUB_EVENT_KEY, false)) {
            invocation.setAttachment(Constants.STUB_EVENT_KEY, Boolean.TRUE.toString());
        }
        return invocation;
    }

    @Override
    public void sent(Channel channel, Object message) throws RemotingException {

    }

    @Override
    public void caught(Channel channel, Throwable exception) throws RemotingException {

    }

    @Override
    public String telnet(Channel channel, String message) throws RemotingException {
        return null;
    }
}
