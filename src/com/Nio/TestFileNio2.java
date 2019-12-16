package com.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class TestFileNio2 {

    //在指定文件中写数据
    public static void main(String[] args) throws Exception{

        File file = new File("test.txt");

        FileInputStream is = new FileInputStream(file);

        //根据文件输入流获取通道
        FileChannel channel = is.getChannel();

        //初始化缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        //将通道中数据读取到缓存区
        channel.read(byteBuffer);

        byte[] array = byteBuffer.array(); //将缓存中的数据转换为字节数组

        System.out.println(new String(array));

        is.close();


    }

}
