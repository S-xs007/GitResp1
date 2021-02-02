package com.dragon.netty.简单的丢弃应用.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardNettyClientHandler extends SimpleChannelInboundHandler<Object> {
    private ByteBuf content;
    private ChannelHandlerContext ctx;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client channel active---");
        this.ctx = ctx;
        content = ctx.alloc().directBuffer(DiscardNettyClient.SIZE).writeZero(DiscardNettyClient.SIZE);
        generateTraffic();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        content.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
    long counter;
    private void generateTraffic() {
        ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficGenerator);
    }
    private ChannelFutureListener trafficGenerator = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if(future.isSuccess()){
                generateTraffic();
            }else {
                future.cause().printStackTrace();
                future.channel().close();
            }
        }
    };
}
