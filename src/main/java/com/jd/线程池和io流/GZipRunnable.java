package com.jd.线程池和io流;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GZipRunnable implements Runnable{
    /**
     * logger  for this class
     */
    Logger logger = LoggerFactory.getLogger(GZipRunnable.class);

    private final File input;

    GZipRunnable(File input){
        this.input = input;
    }
    @Override
    public void run() {
        //排除已经压缩的
        while(!input.getName().endsWith(".gz")){
            File output = new File(input.getParent(),input.getName()+".gz");
            if(!output.exists()){
                try (
                        InputStream in = new BufferedInputStream(new FileInputStream(input));
                        OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));

                ) {
                    int b;
                    while((b = in.read())!= -1) out.write(b);
                    out.flush();

                } catch (FileNotFoundException e) {
                    logger.error("文件没有找到");
                    e.printStackTrace();
                } catch (IOException ioException) {
                    logger.error("传输错误");
                    ioException.printStackTrace();
                }
            }
        }
    }
}
