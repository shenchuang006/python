package org.gaoliyuan.test.bean.load;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentDemoLoad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6512850711469968107L;
	
	private static Logger log = LoggerFactory.getLogger(ParentDemoLoad.class);
	public static final String PARENT_STR = "I am ParentDemoLoad";
	public static String parent_static_str = "I am parent static constant";
	{
		log.debug("---> parentDemoLoad 的代码块执行");
	}
	
	static{
		log.debug("---> parentDemoLoad 的静态代码块执行");
	}
	private String sex;
	private String address;
	public ParentDemoLoad() {
		log.debug("----> parentDemoLoad 的构造器执行");
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static String testParent(){
		log.debug("---> 父类的静态方法");
		return "父类的静态方法";
	}
	@Override
	public String toString() {
		return "ParentDemoLoad [sex=" + sex + ", address=" + address + "]";
	}
}
