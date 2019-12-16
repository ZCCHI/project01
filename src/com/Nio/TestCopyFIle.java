package com.Nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class TestCopyFIle {

    public static void main(String[] args) throws Exception {

        //文件输入流
        FileInputStream is = new FileInputStream("test.txt");

        //文件输出流
        FileOutputStream os = new FileOutputStream("c:\\Text\\test.txt");

        FileChannel channel =is.getChannel(); //获取管道

        FileChannel channel2 = os.getChannel();

        //复制  将管道中的数据进行复制
        channel.transferTo(0,channel.size(),channel2);

        is.close();

        os.close();

    }

}
