package com.example.utilsdemo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: xy
 * @Date: 2025-02-27 17:07
 * @Description:
 */
public class NettyClient {
    public static void main(String[] args) {
        // 客户端需要一个事件循环组
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建客户端启动对象
            // 注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            // 设置相关参数
            bootstrap.group(group) // 设置线程组
                    .channel(NioSocketChannel.class) // 设置客户端通道的实现类(反射)
                    .handler(new ChannelInitializer<SocketChannel>() {
                                 @Override
                                 protected void initChannel(SocketChannel socketChannel) throws Exception {
                                     socketChannel.pipeline().addLast(new NettyClientHandler());  // 加入客户端的handler
                                 }
                             }); // 设置处理器
            System.out.println("!!客户端已准备好!!");
            // 启动客户端去连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
            // 监听关闭通道
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            group.shutdownGracefully();
        }
    }
}
