package org.gaoliyuan.test.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 1 JDK动态代理所用到的代理类在程序调用到代理类对象时才由JVM真正创建，JVM根据传进来的 业务实现类对象 以及 方法名 ，
 * 动态地创建了一个代理类的class文件并被字节码引擎执行，然后通过该代理类对象进行方法调用。我们需要做的，
 * 只需指定代理类的预处理、调用后操作即可 在使用时，
 * 
 * 2 首先创建一个业务实现类对象和一个代理类对象，然后定义接口引用（这里使用向上转型）并用代理对象.bind(业务实现类对象)的返回值进行赋值。最后通过接口引用调用业务方法即可。
 * （接口引用真正指向的是一个绑定了业务类的代理类对象，所以通过接口方法名调用的是被代理的方法们
 * 
 * 3  JDK动态代理的代理对象在创建时，需要使用业务实现类所实现的接口作为参数（因为在后面代理方法时需要根据接口内的方法名进行调用）。如果业务实现类是没有实现接口而是直接定义业务方法的话，
 * 就无法使用JDK动态代理了。并且，如果业务实现类中新增了接口中没有的方法，这些方法是无法被代理的（因为无法被调用）
* @ClassName:BookFacadeProxy 
* @version:1.0.0
* @Description:  
* @author: Sc 
* @date: 2018年12月28日 下午8:36:50
 */
public class BookFacadeProxy implements InvocationHandler {  
    private Object target;//这其实业务实现类对象，用来调用具体的业务方法 
    /** 
     * 绑定业务对象并返回一个代理类  
     */  
    public Object bind(Object target) {  
        this.target = target;  //接收业务实现类对象参数

       //通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
       //创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this); }  
    /** 
     * 包装调用方法：进行预处理、调用后处理 
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object result=null;  

        System.err.println("预处理操作——————");  
        //调用真正的业务方法  
        result=method.invoke(target, args);  

        System.err.println("调用后处理——————");  
        return result;  
    }  
  
}  
