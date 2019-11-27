package org.gaoliyuan.test.bean.instance;

import java.io.Serializable;

public class FemaleEmployee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7110054172013610180L;
	
	private String name;//姓名
	private Integer age;//年龄
	private String address;//地址
	
	public FemaleEmployee() {
		System.err.println("---初始化...");
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "FemaleEmployee [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}
}
