package com.dragon;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*Map<String,Object> map = new HashMap<>();
        map.put("长","2");
        BigDecimal b = new BigDecimal(map.get("长").toString());
        b = b.divide(new BigDecimal("10"));
        map.put("长",b.toString());

        System.out.println(map.get("长").toString());*/
        BigDecimal b = new BigDecimal("1.23129");

        //DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        //b = new BigDecimal(decimalFormat.format(b));
        System.out.println("方法二："+b.toString());


    }


}
