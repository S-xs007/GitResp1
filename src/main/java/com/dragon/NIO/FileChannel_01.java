package com.dragon.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;

public class FileChannel_01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/abc.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();//可以读可以写，如果是r模式就只能读
        Thread a = new Thread(()->{
            try {
                fileChannel.lock(1, 2, false);//true表示共享锁，可以共享获取，阻塞排他锁，排他锁会阻塞一切其他锁
                fileChannel.lock();
                FileLock lock = fileChannel.tryLock();
                System.out.println("锁定是否有效：" + lock.isValid());
                System.out.println("锁定的类型是：" + lock.isShared());
                System.out.println("锁定的范围是" + lock.position()+lock.size());
                System.out.println("锁定的通道：" + lock.acquiredBy());
                boolean b = lock.overlaps(1,3);

                fileChannel.force(true);
                MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,2,4);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //该方法调用期间，其他线程关闭这个通道，会抛出异常
        });
        Thread b = new Thread(()->{
            try {
                fileChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(1000);
        randomAccessFile.close();
        fileChannel.close();
        /*FileOutputStream fileOutputStream = new FileOutputStream(new File("abc.txt"));
        FileChannel fileChannel1 = fileOutputStream.getChannel();   //只可以写（FileInputStream只能读）

        ByteBuffer byteBuffer = ByteBuffer.wrap("111232141".getBytes());
        fileChannel.write(byteBuffer);  //缓冲区剩余字节序列写入到通道绑定的文件（从通道position开始）
        fileChannel1.read(byteBuffer);  //从通道position开始的字节读入到缓冲区剩余空间中
        ByteBuffer b1 = ByteBuffer.allocate(10);
        ByteBuffer b2 = ByteBuffer.allocate(10);
        ByteBuffer b3 = ByteBuffer.allocate(10);
        ByteBuffer[] bs = {b1, b2, b3};
        fileChannel.write(bs);
        fileChannel.write(bs, 2, 3);

        fileChannel.position(100);

        fileChannel.truncate(10);
        fileChannel.transferTo(1, 2, fileChannel1);//fileChannel  位置1开始2个字节转移到fileChannel1
        fileChannel.transferFrom(fileChannel1,2,3);//fileChannel1 转移到fileChannel的position位置3个字节*/


    }
}
