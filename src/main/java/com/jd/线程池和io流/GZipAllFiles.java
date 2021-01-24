package com.jd.线程池和io流;


import java.io.File;
import java.util.concurrent.*;

/**
 * @author coder01
 */
public class GZipAllFiles {

    private final int THREAD_CORE_COUNT = 4;

    public void zipFiles(String[] fileNames){
        BlockingDeque blockingDeque = new LinkedBlockingDeque();
        //自定义线程池，线程数大小4
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 8, 1, TimeUnit.MINUTES, blockingDeque);
        for(String fileName : fileNames){
            File file = new File(fileName);
            if(file.exists()){
                if(file.isDirectory()){
                    File[] files = file.listFiles();
                    for(File file1 : files){
                        pool.submit(new GZipRunnable(file));
                    }
                }else {
                    pool.submit(new GZipRunnable(file));
                }

            }
        }
        pool.shutdown();
    }
}
