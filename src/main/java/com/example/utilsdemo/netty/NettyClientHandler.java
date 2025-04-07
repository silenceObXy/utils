package com.example.utilsdemo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


/**
 * @Author: xy
 * @Date: 2025-02-27 17:09
 * @Description:
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    // 当通道就绪时就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端: " + ctx);
        // 向服务端发送数据
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,world!", CharsetUtil.UTF_8));
    }

    // 当通道有读取事件时,会触发该方法

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务端回复的消息: " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器的地址: " + ctx.channel().remoteAddress());
    }

    // 发生异常时回调,关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
