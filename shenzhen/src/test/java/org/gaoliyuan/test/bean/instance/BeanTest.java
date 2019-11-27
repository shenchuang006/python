package org.gaoliyuan.test.bean.instance;

import org.springframework.context.ApplicationContext;

public class BeanTest {
	 public static void main(String args[]) {  
		 BeanTest test = new BeanTest();  
	        test.test();  
	    }  
	  
	    public void test() {  
	        ApplicationContext context = BeanContextHelper.getApplicationContext();  
	        Employee employee = (Employee) context.getBean("employee");  
	        System.out.println("**********从Spring BeanFactory获取到的最终bean实例**********");  
	        System.out.println("最终bean的值：" + employee);  
	    }
}
