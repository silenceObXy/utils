package com.example.utilsdemo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: xy
 * @Date: 2025-02-27 16:40
 * @Description:
 */
public class NettyServer {
    public static void main(String[] args) {
        /**
         * 流程:
         * 1.创建两个线程组 bossGroup 和 workerGroup
         * 2.bossGroup只负责连接请求的处理,workerGroup完成客户端业务处理
         * 3.两个线程组都置为无线循环
         * 4.bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数默认为 实际cpu核数*2
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try {
            //创建服务端的启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //配置参数
            serverBootstrap.group(bossGroup, workerGroup)// 设置两个线程组
                    .channel(NioServerSocketChannel.class) // 使用NioSocketChannel
                    .option(ChannelOption.SO_BACKLOG, 128)// 设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  // 设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 创建通道初始化对象
                        // 给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("客户端socketChannel hashCode = " + socketChannel.hashCode());
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });// 给workerGroup的EventLoop对应的管道配置处理器
            System.out.println("!!服务器已准备好!!");
            // 绑定端口并且同步,生成一个ChannelFuture对象
            // 启动服务器(并绑定端口)
            ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();
            // 给ChannelFuture注册监听器，监听关闭事件
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口6666成功");
                    } else {
                        System.out.println("监听端口6666失败");
                    }
                }
            });
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
