package com.sxh.spring.netty;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeServerHandler.class);
	/**
	 * 对网络事件进行写操作
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// Netty中的ByteBuf类似于nio类库中的ByteBuffer，不过功能更强大
		ByteBuf buf = (ByteBuf)msg;
		// 创建与buf一样大小的字节数组
        byte[] req = new byte[buf.readableBytes()];
        // 将数据从buf中复制到req中
        buf.readBytes(req);
        
        String body = new String(req, "UTF-8");
        LOGGER.info("服务端取到的信息为:" + body);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? 
        		new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        // 创建ByteBuf对象
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        // 通过ChannelHandlerContext的write方法异步发送给客户端
        ctx.write(resp);
	}
	/**
	 * 写操作完成之后进行的操作
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// ctx.write()只是将消息放到发送缓冲数组中，调用flush就将其发送缓冲区中的消息全部写到SocketChannel中
		ctx.flush();
	}
	/**
	 * 释放资源
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
