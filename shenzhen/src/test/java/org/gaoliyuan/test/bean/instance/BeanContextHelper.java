package org.gaoliyuan.test.bean.instance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * Bean上下文工具类 
 */  
public class BeanContextHelper {  
    private static ApplicationContext _instance;  
  
    static {  
        if (_instance == null)  
            _instance = buildApplicationContext();  
    }  
  
    private BeanContextHelper() {  
    }  
  
    /** 
     * 重新构建ApplicationContext对象  
     */  
    public static ApplicationContext buildApplicationContext() {  
        return new ClassPathXmlApplicationContext("classpath:applicationContext-base.xml");  
    }  
  
    /** 
     * 获取一个ApplicationContext对象 
     */  
    public static ApplicationContext getApplicationContext() {  
        return _instance;  
    }  
}  
