package com.Nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class NioClient {

    public static void main(String[] args) throws Exception {

        //1获取网络通道
        SocketChannel channel = SocketChannel.open();

        channel.configureBlocking(false);//非阻塞

        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);

        //连接
        if(!channel.connect(address)){
            while (!channel.finishConnect()){
                System.out.println("没有连接成功 可以干些其他事");

            }
        }

        //把数据设置到缓存区
        ByteBuffer buffer = ByteBuffer.wrap("你好！".getBytes());
        //把缓存区中的数据存储到网络通道中
        channel.write(buffer);

        System.in.read();
    }

}
