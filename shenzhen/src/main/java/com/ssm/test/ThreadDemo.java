package com.ssm.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService =Executors.newFixedThreadPool(3);
		//其实就是返回一个runnable对象
		executorService.execute(new Runnable() {
			String name;
			Integer age;
			public Runnable accept(String name,Integer age){
				this.name = name;
				this.age = age;
				return this;
			}
			
			@Override
			public void run() {
				System.err.println("--->,name" + this.name+",age:" +this.age);
			}
		}.accept("Jim", 10));
		
		ExecutorService rollbacks =Executors.newFixedThreadPool(3);
		
		final CountDownLatch latch = new CountDownLatch(3);
		for(int i = 0 ; i < 3;i++){
			rollbacks.execute(new Runnable() {
				@Override
				public void run() {
					System.err.println("--->当前线程名称:" + Thread.currentThread().getName());
					latch.countDown();
				}
			});
		}
		latch.await();
		System.err.println("--->执行完毕");
		int i = 0;
		while(true){
			if(i == 3){
				System.err.println("停止运行");
				break;
			}
			i++;
		}
	}

}
