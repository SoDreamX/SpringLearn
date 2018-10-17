package com.sxh.spring.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty服务端DEMO
 * @author Sxh
 * 2018年10月17日 上午11:47:15
 */
public class TimeServer {
	/**
	 * 绑定端口号，启动Netty服务端
	 * @param port
	 * @throws Exception
	 */
	public void bind(int port) throws Exception{
		// NioEventLoopGroup是个线程组，它包含了一组NIO线程，专门用于网络事件的处理
        // 实际上它们就是Reactor线程组，关于Reactor，这是一种设计模型，
        // Reactor模型就是将消息放到了一个队列中，通过异步线程池对其进行消费
        // 在Netty中就是，NioEventLoopGroup就是Reactor，ChannelHandler就是Reactor模型中的handler
        // 这里创建了两个线程组，一个用于服务端接受客户端的连接，一个用于进行SocketChannel的网络读写
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup wokerGroup = new NioEventLoopGroup();
		try {
			// 创建NIO服务端的辅助启动类，目的是降低服务端的开发复杂度
			ServerBootstrap b = new ServerBootstrap();
			// 将两个NIO线程组作为参数传递到ServerBootstrap中
			b.group(bossGroup, wokerGroup)
				// NioServerSocketChannel对应JDK NIO类库中的ServerSocketChannel
				.channel(NioServerSocketChannel.class)
				// 设置NioServerSocketChannel的TCP参数
				.option(ChannelOption.SO_BACKLOG, 1024)
				// 绑定I/O事件的处理类ChildChannelHandler，它的作用类似于Reactor模式中的Handler类
                // 主要用于处理网络I/O事件，例如记录日志、对消息进行编解码等
				.childHandler(new ChildChannelHandler());
			
			// 绑定端口，同步等待成功，该方法是同步阻塞的，绑定成功后返回一个ChannelFuture
			ChannelFuture f = b.bind(port).sync();
			// 等待服务端监听端口关闭，阻塞，等待服务端链路关闭之后main函数才退出
            f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放线程池资源
			bossGroup.shutdownGracefully();
			wokerGroup.shutdownGracefully();
		}
		
	}
	/**
	 * 实现initChannel方法，其作用是当创建NioServerSocketChannel成功之后，
     * 在进行初始化时，将它的ChannelHandler设置到ChannelPipeline中，用于处理网络I/O事件
	 * @author Sxh
	 * 2018年10月17日 下午1:07:54
	 */
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }
    
    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new TimeServer().bind(port);
    }
}
