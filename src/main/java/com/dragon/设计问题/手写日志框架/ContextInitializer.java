package com.dragon.设计问题.手写日志框架;

import com.dragon.设计问题.手写日志框架.config.Configurator;
import com.dragon.设计问题.手写日志框架.config.XMLConfigurator;
import com.dragon.设计问题.手写日志框架.config.YAMLConfigurator;

import java.net.URL;

/**
 * 读取配置文件
 */
public class ContextInitializer {
    public final static String AUTOCONFIG_FILE = "logc.xml";
    public final static String YAML_FILE = "logc.yml";

    private static final LoggerContext DEFAULT_LOGGER_CONTEXT = new LoggerContext();

    static {
    }

    public static void autoconfig() {
        URL url = getConfigURL();
        if(url == null){
            throw new RuntimeException("config file not found!");
        }
        String urlString = url.toString();
        Configurator configurator = null;

        if(urlString.endsWith("xml")){
            configurator = new XMLConfigurator(url,DEFAULT_LOGGER_CONTEXT);
        }
        if(urlString.endsWith("yml")){
            configurator = new YAMLConfigurator(url,DEFAULT_LOGGER_CONTEXT);
        }
        configurator.doConfigure();
    }

    /**
     * 获取指定文件的url xml/yml
     * @return
     */
    private static URL getConfigURL(){
        URL url = null;
        //获取当前类的类加载器
        ClassLoader classLoader = ContextInitializer.class.getClassLoader();
        url = classLoader.getResource(AUTOCONFIG_FILE);
        if(url != null){
            return url;
        }
        url = classLoader.getResource(YAML_FILE);
        if(url != null){
            return url;
        }
        return null;
    }

    public static LoggerContext getDefautLoggerContext(){
        return DEFAULT_LOGGER_CONTEXT;
    }

}
