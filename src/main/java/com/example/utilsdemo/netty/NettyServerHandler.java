package com.example.utilsdemo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @Author: xy
 * @Date: 2025-02-27 17:01
 * @Description:
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 1. ChannelHandlerContext ctx:上下文对象,含有管道pipeline,通道channel,地址
     * 2. Object msg:客户端发来的数据,默认Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 " + Thread.currentThread().getName() + " channel = " + ctx.channel());
        System.out.println("server ctx = " + ctx);
        // 获取channel
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();
        // 将 msg 转成 ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发来消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址:" + channel.remoteAddress());
    }

    // 数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // writeAndFlush 是 write + flush 操作, 将数据写入到缓存并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,please stop the war!", CharsetUtil.UTF_8));
    }

    // 有异常时回调到这里,一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
