package com.ssm.test;

/**
 * ①父类静态代码块>>②子类静态代码块>>③父类非静态代码块>>④父类构造函数>>⑤子类非静态代码块>>⑥子类构造函数

大致总结:

父类早于子类，静态早于非静态，非静态早于构造函数。
* @ClassName:TestClass 
* @version:1.0.0
* @Description:  
* @author: Sc 
* @date: 2019年11月7日 下午3:57:52
 */
public class TestClass {
    public static void main(String[] args) {
        //new Child("param");
        //new Child("param");
    	TestClass testClass = new TestClass();
    	int a = testClass.test();
    	System.err.println(a);
    }
    public int test(){
    	int a = 1;
    	try{
    		a = 3;
    		System.err.println("try:"+a);
    		return a;
    	}catch(Exception e){
    		
    	}finally{
    		a = 2;
    		System.err.println("finally:"+a);
    		return a;
    	}
    }
}
 
class Parent {
    static {
        System.out.println("执行父类静态代码块");
    }
 
    {
        System.out.println("执行父类构造代码块");
    }
 
    Parent() {
        System.out.println("执行父类无参数构造方法");
    }
 
    Parent(String str) {
        System.out.println("执行父类带参数构造方法，参数：" + str);
    }
 
}
 
class Child extends Parent {
    static {
        System.out.println("执行子类静态代码块");
    }
 
    {
        System.out.println("执行子类构造代码块");
    }
 
    Child() {
        System.out.println("执行子类无参数构造方法");
    }
 
    Child(String str) {
        super(str);
        System.out.println("执行子类带参数构造方法，参数" + str);
    }
 
}
