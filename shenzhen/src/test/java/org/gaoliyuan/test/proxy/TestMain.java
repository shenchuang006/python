package org.gaoliyuan.test.proxy;

import java.math.BigDecimal;

import org.gaoliyuan.test.proxy.dynamic.cglib.BookFacadeCglib;
import org.gaoliyuan.test.proxy.dynamic.cglib.BookFacadeImpl1;
import org.gaoliyuan.test.proxy.dynamic.jdk.BookFacade;
import org.gaoliyuan.test.proxy.dynamic.jdk.BookFacadeImpl;
import org.gaoliyuan.test.proxy.dynamic.jdk.BookFacadeProxy;
import org.gaoliyuan.test.proxy.statics.CountImpl;
import org.gaoliyuan.test.proxy.statics.CountProxy;
import org.junit.Test;

public class TestMain {
	/**
	 * 
	* @Description: 静态代理
	* @param args 
	* void
	*
	 */
	public static void main(String[] args) {  
        /*CountImpl countImpl = new CountImpl();  
        CountProxy countProxy = new CountProxy(countImpl);  
        countProxy.updateCount();  
        countProxy.queryCount();*/
		BigDecimal bigDecimal = new BigDecimal(0.000);
		if(bigDecimal.compareTo(BigDecimal.ZERO) == 0){
			System.err.println("----");
		}
		
    }
	/**
	 * jdk中动态代理
	 */
	@Test
	public void testJdk(){
		BookFacadeImpl bookFacadeImpl=new BookFacadeImpl();
        BookFacadeProxy proxy = new BookFacadeProxy();  
        BookFacade bookfacade = (BookFacade) proxy.bind(bookFacadeImpl);
        bookfacade.addBook();
	}
	/**
	 * cglib中动态代理
	 */
	public void testCglib(){
		BookFacadeImpl1 bookFacade=new BookFacadeImpl1();
        BookFacadeCglib  cglib=new BookFacadeCglib();  
        BookFacadeImpl1 bookCglib=(BookFacadeImpl1)cglib.getInstance(bookFacade);  
        bookCglib.addBook();
	}
	/**
	 * 从上面的结果来看，总的来说就是：break是跳出当前循环（最接近的循环），继续外层循环；continue则是结束本次循环，
	 * continue后面的代码不执行，继续后面的循环，也就是说还是在同一个循环内，与break有所不同，
	 * break则是跳到了外层循环；return则是终止当前的方法，
	 * 该方法后面的代码都将不会执行。这些也只是我粗略测试的结果，如果各位有比较好的补充请留言，我会进行相应的修改
	* @Description:  
	* void
	*
	 */
	@Test
	public void testMx(){
		for(int i = 0;i<10;i++){
			for(int j=0;j<6;j++){
				if(i == 3 && j == 3){
					System.err.println("----程序结束");
					return;
					
				}
			}
			System.err.println("-----");
		}
	}
}
