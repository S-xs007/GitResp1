package com.dragon;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*byte[] bytes = "你好我是中国人".getBytes("utf-16BE");
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        for(int i =0;i<charBuffer.length();i++){
            System.out.print(charBuffer.get(i));
        }
        charBuffer.position(2);
        charBuffer.compact();
        for(int i =0;i<charBuffer.length();i++){
            System.out.print(charBuffer.get(i));
        }
        ByteBuffer b1 = ByteBuffer.allocate(10);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(b1.capacity()+100);*/
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append("ancbdadw");
        char[] cc = charBuffer.array();
        for(int i = 0;i<charBuffer.capacity();i++){
            System.out.println(charBuffer.get(i));
        }
        charBuffer.position(2);
        charBuffer.charAt(0);   //从position开始算 ，返回c
        charBuffer.charAt(1);   //返回b
        charBuffer.subSequence(2,4);    //从position为0开始算  position+2 ~ position+4


    }


}
