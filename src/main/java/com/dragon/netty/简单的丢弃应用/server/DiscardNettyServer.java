package com.dragon.netty.简单的丢弃应用.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class DiscardNettyServer {
    /**
     * 默认端口
     */
    static final int PORT = Integer.parseInt(System.getProperty("8686"));

    public static void main(String[] args) {
        //用于处理客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //NioEventLoopGroup就是一个基于Reactor模式的线程池
        //用于处理IO操作的多线程事件循环
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            //ServerBootstrap的核心就是用于服务器的初始化
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup)
             .channel(NioServerSocketChannel.class)
             .handler(new LoggingHandler(LogLevel.INFO))
             .childHandler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline pipeline = ch.pipeline();
                     pipeline.addLast(new DiscardNettyServerHandler());
                 }
             });
            ChannelFuture f = b.bind(PORT).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }
}
