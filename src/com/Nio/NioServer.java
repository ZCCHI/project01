package com.Nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class NioServer {

    public static void main(String[] args) throws Exception{

        //服务端网络连接通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9999));//设置服务端口

        serverSocketChannel.configureBlocking(false);

        //选择器
        Selector selector = Selector.open();

        //服务器网络通道注册选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            //用选择器监控客户端的连接
            if(selector.select(2000) == 0){

                System.out.println("客户端没人搭理我就干点别的事");
                continue;

            }
            
            //有客户端连接
            Iterator<SelectionKey> iteratorkey = selector.selectedKeys().iterator();

            while (iteratorkey.hasNext()){
                SelectionKey key = iteratorkey.next();

                if(key.isAcceptable()){
                    System.out.println("客户端有连接。。。。");
                    //有连接
                    SocketChannel socketChannel = serverSocketChannel.accept(); //服务端接受连接获取网络通道
                    socketChannel.configureBlocking(false);//非阻塞式
                    //再给连接通道注册选择器事件 重点监控Read事件,
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if(key.isReadable()){
                    //有数据
                    SocketChannel channel = (SocketChannel)key.channel();
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发过来的数据："+new String(buffer.array()));
                }

                iteratorkey.remove();//移除SelectionKey的
            }


        }

    }

}
