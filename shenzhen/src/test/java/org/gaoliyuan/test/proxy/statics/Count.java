package org.gaoliyuan.test.proxy.statics;

/** 
 * 定义一个账户接口 
 * @author Administrator
 */
/**
 *  静态代理的缺点很明显：一个代理类只能对一个业务接口的实现类进行包装，如果有多个业务接口的话就要定义很多实现类和代理类才行。而且，
 *  如果代理类对业务方法的预处理、调用后操作都是一样的（比如：调用前输出提示、调用后自动关闭连接），则多个代理类就会有很多重复代码。
 *  这时我们可以定义这样一个代理类，它能代理所有实现类的方法调用：根据传进来的业务实现类和方法名进行具体调用。——那就是动态代理
* @ClassName:Count 
* @version:1.0.0
* @Description:  
* @author: Sc 
* @date: 2018年12月28日 下午8:12:22
 */
public interface Count {  
    // 查询账户
    public void queryCount();  
  
    // 修改账户  
    public void updateCount();  
  
}  
