package com.dragon.设计模式.proxy;



import java.io.*;

/**
 * 自定义类加载器，在指定的路径下加载指定的字节码文件
 */
public class CPClassLoader extends ClassLoader {
    //
    private File classPath;
    public CPClassLoader(){
        String classPath = CPClassLoader.class.getResource("").getPath();
        this.classPath = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获得类名的全限定类名
        String className = CPClassLoader.class.getPackage().getName()+"."+name;
        if(classPath!=null){
            //根据父类抽象路径和子类的路径名创建出一个新的File
            File classFile = new File(classPath,name.replace("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in = null;  //文件写入内存的流
                ByteArrayOutputStream out = null;   //字节外流
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    //将byte字节流解析成JVM能够识别的class对象
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
