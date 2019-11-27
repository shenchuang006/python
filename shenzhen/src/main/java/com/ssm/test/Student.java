package com.ssm.test;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9174954866240174124L;
	
	private String name;
	private Integer age;
	public Student() {
		
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		final ConcurrentHashMap<String,Integer> currentMap = new ConcurrentHashMap<String,Integer>();
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		boolean isFlage = false;
		if(!isFlage){
			isFlage = true;
			System.err.println("11111");
		}else if(isFlage){
			System.err.println("--->");
		}
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("--->:1" + Thread.currentThread().getName());
				String key = "abc";
				System.err.println("--->1:"+currentMap);
				if(currentMap.get(key) == null){
					Integer abc = currentMap.put(key, 6);
					System.err.println("--->1:"+abc);
					System.err.println("1<--->1:"+currentMap);
				}else{
					System.err.println("1<--->1:数据已经存在");
					return;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("--->:2" + Thread.currentThread().getName());
				String key = "abc";
				System.err.println("--->2:"+currentMap);
				if(currentMap.get(key) == null){
					Integer abc = currentMap.put(key, 4);
					System.err.println("--->2:"+abc);
					System.err.println("2--->2:"+currentMap);
				}else{
					System.err.println("2--->2:数据已经存在");
					return;
				}
			}
		});
		
		t1.start();
		t2.start();
		//System.err.println(currentMap);
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				/*System.err.println("--->:3" + Thread.currentThread().getName());
				String key = "abc";
				System.err.println("--->3:"+currentMap);
				if(currentMap.get(key) == null){
					Integer abc = currentMap.put(key, 3);
					System.err.println("--->3:"+abc);
				}*/
				System.err.println("--->:mmm" + Thread.currentThread().getName());
			}
		});
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				/*System.err.println("--->:4" + Thread.currentThread().getName());
				String key = "abc";
				System.err.println("--->4:"+currentMap);
				if(currentMap.get(key) == null){
					Integer abc = currentMap.put(key, 4);
					System.err.println("--->4:"+abc);
				}*/
				int a = 1/0;
			}
		});
		executorService.execute(t3);
		executorService.execute(t4);
	}
	

}
