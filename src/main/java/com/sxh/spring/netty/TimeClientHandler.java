package com.sxh.spring.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeClientHandler extends ChannelHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClientHandler.class);
    
    private final ByteBuf firstMessage;
    /**
     * 初始化需要发送的数据
     */
    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }
    /**
     * 当客户端和服务端TCP链路建立成功之后，Netty的NIO线程会调用channelActive方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	// 将请求消息发送给服务端
        ctx.writeAndFlush(firstMessage);
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        
        String body = new String(req, "UTF-8");
        LOGGER.info("客户端取到返回的信息为:" + body);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.warn("Unexcepted exception from downstream:" + cause.getMessage());
        ctx.close();
    }
}
