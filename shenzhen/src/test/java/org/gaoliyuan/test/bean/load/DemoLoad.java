package org.gaoliyuan.test.bean.load;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoLoad extends ParentDemoLoad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4886689357108644707L;
	
	private static Logger log = LoggerFactory.getLogger(DemoLoad.class);
	
	public static final String CHILD_STR = "I am child demoLoad";
	
	public static String child_static_str = "I am child static constant";
	
	private String name;
	private Integer age;
	
	{
		log.debug("----> demoLoad 的代码块执行");
	}
	static{
		log.debug("----> demoLoad 的静态代码块执行");
	}
	
	public DemoLoad() {
		log.debug("---> demoLoad 构造器执行 ");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static String childTest(){
		log.debug("----> child Demoload类");
		return "child Demoload类";
	}
	
	@Override
	public String toString() {
		return "DemoLoad [name=" + name + ", age=" + age + "]";
	}
	
}
