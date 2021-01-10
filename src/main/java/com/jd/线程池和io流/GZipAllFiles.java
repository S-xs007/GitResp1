package com.jd.线程池和io流;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GZipAllFiles {

    private final int THREAD_CORE_COUNT = 4;

    public void zipFiles(String[] fileName){
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_CORE_COUNT);
        for(String name : fileName){
            File file = new File(name);
            if(file.exists()){
                if(file.isDirectory()){ //是目录
                    File[] files = file.listFiles();
                    for(int i = 0;i<file.length();i++){
                        if(!files[i].isDirectory()){
                            Runnable task = new GZipRunnable(files[i]);
                            pool.submit(task);
                        }
                    }
                }else { //不是目录
                    Runnable task = new GZipRunnable(file);
                    pool.submit(task);
                }
            }
        }
        pool.shutdown();
    }
}
