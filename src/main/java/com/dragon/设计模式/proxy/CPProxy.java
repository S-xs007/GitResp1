package com.dragon.设计模式.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来生成动态代理类源码的工具类
 * 1.根据提供的接口拼接文件
 * 2.拼接好的java输出到目录中
 * 3.把他编译成class文件
 * 4.把生成的class文件加载到内存中
 * 5.用反射生成实例并且返回
 */
public class CPProxy {
    public static final String ln = "\r\n";

    /**
     * 返回代理类的对象实例
     * @param classLoader   类加载器
     * @param interfaces    接口
     * @param cpInvocationHandler   中间类
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static Object newProxyInstance(CPClassLoader classLoader,Class<?>[] interfaces,CPInvocationHandler cpInvocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException {
        //动态生成源码.java文件
        String src = generateSrc(interfaces);
        //java文件输出磁盘(把生成的java文件输出到给定的文件中)
        String filePath = CPProxy.class.getResource("").getPath();
        File f = new File(filePath+"$Proxy0.java");
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //把生成的.java文件编译为.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manager.getJavaFileObjects(f);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
        task.call();
        manager.close();

        //编译生成的class文件加载到jvm
        Class proxyClass  = classLoader.findClass("$Proxy0");
        Constructor c = proxyClass.getConstructor(CPInvocationHandler.class);
        f.delete(); //加载到jvm之后删除源文件

        //返回字节码重组之后的新的代理对象
        try {
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(CPProxy.class.getPackage()+";"+ln);   //package com.dragon.设计模式.proxy;
        sb.append("import "+ interfaces[0].getName()+";"+ln);   //导入接口
        sb.append("import java.lang.reflect.*"+ln );    //导入包
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+ln);   //开始类的定义
            sb.append("CPInvocationHandler h;"+ln);     //定义一个CPInvocationHandler的引用
            //拼接构造方法
            sb.append("public $$Proxy0(CPInvocationHandler h) {"+ln);
                sb.append("this.h = h;"+ln);
                sb.append("};"+ln);
                //开始遍历接口中的方法，在方法内部遍历参数，然后拼接参数
               for(Method m:interfaces[0].getMethods()){
                   Class<?>[] params = m.getParameterTypes();   //方法的参数类型
                   StringBuffer paramNames = new StringBuffer();    //参数列表
                   StringBuffer paramValues = new StringBuffer();   //
                   StringBuffer paramClasses = new StringBuffer();  //

                   for(int i = 0;i < params.length;i++){
                       Class clazz = params[i];
                       String type = clazz.getName();       //参数类型
                       String paramName = toLowerFirstCase(clazz.getSimpleName());  //参数类型首字母小写就是参数名
                       paramNames.append(type+" "+paramName);       // 类似于Proxy proxy
                       paramValues.append(clazz.getName()+".class");//Proxy.class
                       if(i>0&&i<params.length-1){  //参数还没有遍历完，就加逗号分割
                           paramNames.append(",");
                           paramClasses.append(",");
                           paramValues.append(",");
                       }
                   }
                    //开始拼接方法
                   sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"("+paramNames.toString()+") {"+ln);
                   sb.append("try {"+ln);
                   sb.append("Method m = "
                           +interfaces[0].getName()
                           +".class.getMethod(\"" + m.getName() +"\",new Class[]{" + paramClasses.toString()+"});"+ln);
                   sb.append("}catch(Error _ex){ }");
                   sb.append("catch(Throwable e){"+ln);
                   sb.append("throw new UndeclaredThrowableException(e);"+ln);
                   sb.append("}");
                   sb.append(getReturnEmptyCode(m.getReturnType()));
                   sb.append("}");
               }
               sb.append("}"+ln);
               return sb.toString();
    }

    //搞定返回值类型
    private static Map<Class,Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class,Integer.class);
    }
    private static String getReturnEmptyCode(Class<?> returnClass) {
        if(mappings.containsKey(returnClass)){
            return "return 0";
        }else if(returnClass == void.class){
            return "";
        }else{
            return "return null;";
        }
    }
    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "(("+mappings.get(returnClass).getName() +")"+code+")."+returnClass.getSimpleName()+"Values()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    /**
     * 字符串首字母变小写
     * @param simpleName
     * @return
     */
    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(CPProxy.class.getPackage()+";"+ln);
        System.out.println(CPProxy.class.getResource("").getPath());
    }
}
