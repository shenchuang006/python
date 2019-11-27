package org.gaoliyuan.test.bean.load;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class TestLoad {
	
	private Logger logger = LoggerFactory.getLogger(TestLoad.class);
	
	private void test(DemoLoad demoLoad){
		if(demoLoad == null){
			demoLoad = new DemoLoad();
		}
	}
	
	private void test1(DemoLoad demoLoad){
		demoLoad.setAge(30);
		demoLoad.setName("Jerry");
	}
	
	public static void main(String[] args) {
		TestLoad testLoad = new TestLoad();
		DemoLoad demoLoad = null;
		System.err.println("----demoLoad 是否实例化过" + demoLoad);
		testLoad.test(demoLoad);
		System.err.println("---> 调用test方法后:" + demoLoad);
		DemoLoad demoLoad2 = new DemoLoad();
		demoLoad2.setAge(40);
		System.err.println("---> 1-- " + JSONObject.toJSONString(demoLoad2));
		testLoad.test1(demoLoad2);
		System.err.print("---> 2-- " + JSONObject.toJSONString(demoLoad2));
	}
	/**
	 *  [2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:22) - ---> parentDemoLoad 的静态代码块执行
	 *	[2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.DemoLoad:26) - ----> demoLoad 的静态代码块执行
	 *	[2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:18) - ---> parentDemoLoad 的代码块执行
	 *	[2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:27) - ----> parentDemoLoad 的构造器执行
	 *	[2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.DemoLoad:23) - ----> demoLoad 的代码块执行
	 *	[2018-12-28 15:20:44 DEBUG] [main] (org.gaoliyuan.test.bean.load.DemoLoad:30) - ---> demoLoad 构造器执行 
	* @Description:  
	* void
	*
	 */
	@Test
	public void test2(){
		//验证父子类的加载顺序
		DemoLoad demoLoad = new DemoLoad();
	}
	/**
	 * 验证类的主动加载和被动加载
	 * [2018-12-28 15:36:56 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:23) - ---> parentDemoLoad 的静态代码块执行
	 * [2018-12-28 15:36:56 DEBUG] [main] (org.gaoliyuan.test.bean.load.DemoLoad:28) - ----> demoLoad 的静态代码块执行
	 * [2018-12-28 15:36:56 DEBUG] [main] (org.gaoliyuan.test.bean.load.DemoLoad:48) - ----> child Demoload类
	 * [2018-12-28 15:36:56 DEBUG] [main] (org.gaoliyuan.test.bean.load.TestLoad:61) - ----> 主动加载类(静态方法):child Demoload类
	* @Description:  调用子类的静态方法和静态变量 只会加载父类的静态数据    ---不会创建实例
	* void
	*
	 */
	@Test
	public void test3(){
		logger.debug("----> 主动加载类(静态变量):" + DemoLoad.child_static_str);
		//logger.debug("----> 主动加载类(静态方法):" + DemoLoad.childTest());
	}
	/**
	 * [2018-12-28 15:45:22 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:23) - ---> parentDemoLoad 的静态代码块执行
	   [2018-12-28 15:45:22 DEBUG] [main] (org.gaoliyuan.test.bean.load.ParentDemoLoad:43) - ---> 父类的静态方法
	   [2018-12-28 15:45:22 DEBUG] [main] (org.gaoliyuan.test.bean.load.TestLoad:75) - ---调用父类的静态方法:父类的静态方法
	* @Description:子类调用父类的变量信息  不会加载子类静态数据
	* void
	*
	 */
	@Test
	public void test4(){
		logger.debug("---调用父类的静态方法:" + DemoLoad.testParent());
		
		//logger.debug("----调用父类的静态变量:" + DemoLoad.parent_static_str );
	}
}
