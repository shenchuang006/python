package com.ssm.test;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.xmlrpc.base.Array;

public class TestObject {
	
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setAge(30);
		TestObject testObject = new TestObject();
		testObject.testPerson(person, "Jackson", 31);
		System.err.println(JSON.toJSONString(person));
		Person p = null;
		testObject.testNullPerson(p);
		System.err.println(JSON.toJSONString(p));
		Person pm = null;
		Person ps = testObject.testNOtNullPerson(pm);
		System.err.println(JSON.toJSONString(ps));
//		StringBuilder sb = new StringBuilder();
//		//sb.append(null);
//		sb.append("");
//		//sb.append(null);
//		System.err.print(sb.toString());
//		List<String> abcList = null;
//		for(String str: abcList){
//			System.err.println(str);
//		}
		
		//出库单CGTH20190523000008CU201903075221不支持取消操作
		String str = "出库单";
		String message = str.replaceAll("CGTH20190523000008CU201903075221","abc");
		System.err.println("--->:"+message);
		//new Comparator<Date>
		//Comparator<Date>
		List<Date> set = new ArrayList<Date>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		set.add(sdf.parse("2018-08-09 11:00:00"));
		set.add(sdf.parse("2019-08-09 11:00:00"));
		 System.err.println("--->1"+set);
		 Collections.sort(set, new Comparator<Date>() {
				@Override
				public int compare(Date o1, Date o2) {
					if(o1.getTime() > o2.getTime()){
						return 1;
					}else if(o1.getTime() == o2.getTime()){
						return 0;
					}else{
						return -1;
					}
					
				}
		    });
		 System.err.println(set);
		 
		 
		 Collections.sort(set, new Comparator<Date>() {
				@Override
				public int compare(Date o1, Date o2) {
					if(o1.getTime() > o2.getTime()){
						return -1;
					}else if(o1.getTime() == o2.getTime()){
						return 0;
					}else{
						return 1;
					}
					
				}
		    });
		 
		 System.err.println("--->2" +set);
	}

	void testPerson(Person person,String name,Integer age){
		person.setAge(age);
		person.setName(name);
	}
	
	void testNullPerson(Person person){
		if(person == null){
			person = new Person();
			person.setAge(32);
			person.setName("Jim");
		}
	}
	
	Person testNOtNullPerson(Person person){
		if(person == null){
			person = new Person();
			person.setAge(36);
			person.setName("Jerry");
		}
		return person;
	}
}

class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6812404768042018758L;
	
	private String name;
	private Integer age;
	public Person() {
		
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
}
