package com.Nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangchi
 * @create 2019-12-07
 * 文件的NIO
 */
public class TestFileNio {

    //向指定文件中写文件
    public static void main(String[] args) throws Exception{
        //1.获取文件输出流
        FileOutputStream os = new FileOutputStream("test.txt");
        //2.从流中获取一个通道
        FileChannel channel = os.getChannel();
        //3.获取缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4.把数据写入到缓存区
        byteBuffer.put("hello nio".getBytes());
        //5.反转缓存区

        //6.把缓存的数据写到通道中
        channel.write(byteBuffer);
        os.close();
    }

}
