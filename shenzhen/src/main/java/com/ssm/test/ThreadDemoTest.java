package com.ssm.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class ThreadDemoTest {
	private static ExecutorService executorService =Executors.newFixedThreadPool(3);
	
	public static void test1(final CopyOnWriteArrayList<Integer> list){
		System.err.println("--->mmm1");
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i < 10;i++){
					list.add(i);
				}
			}
		});
		System.err.println("--->mmm2");
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				for(int i = 10;i < 20;i++){
					list.add(i);
				}
			}
		});
		System.err.println("--->mmm3");
	}
	
	public static void main(String[] args) throws Exception {
		final AtomicLong ln = new AtomicLong();
		ln.getAndSet(1000L);
		System.err.println(ln.get());
		ln.getAndSet(6000L);
		System.err.println(ln.get());
		//for(int i = 0 ; i < 5;i++){
			System.err.println("--->1");
			final CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
			//ThreadDemoTest.test1(list);
			System.err.println("--->2");
			Thread t2 = new Thread(new Runnable() {
				private CopyOnWriteArrayList<Integer> list;
				public Runnable accept(CopyOnWriteArrayList<Integer> list){
					this.list = list;
					return this;
				}
				@Override
				public void run() {
					System.err.println("--->testmmm1");
					executorService.execute(new Runnable() {
						@Override
						public void run() {
							for(int i = 0;i < 10;i++){
								list.add(i);
							}
							ln.getAndSet(1000L);
						}
					});
					System.err.println("--->testmmm2");
					executorService.execute(new Runnable() {
						@Override
						public void run() {
							for(int i = 10;i < 20;i++){
								list.add(i);
							}
							ln.getAndSet(8000L);
						}
					});
					System.err.println("--->testmmm3");
				}
			}.accept(list));
			Thread t1 = new Thread( new Runnable() {
				@Override
				public void run() {
					System.err.println("--->thread:3");
					System.err.println("--->list:"+list);
					ln.getAndSet(9000L);
				}
			});
			t2.start();
			t2.join();
			t1.start();
			t1.join();
			System.err.println("--->list:"+list);
			
			System.err.println("--->"+ln.get());
		//}
		AtomicInteger count = new AtomicInteger();
		ThreadDemoTest.test3(count);
		while(count.get() != 5){
			System.err.println("no equal five ,it is " + count.get());
			Thread.sleep(1000l);
		}
		System.err.println(count.get());
		executorService.shutdown();
	}
	
	public static void test3(AtomicInteger count){
		for(int i = 0;i < 5;i++){
			executorService.submit(new TaskDetail(count));
		}
	}
}
class TaskDetail implements Runnable{
	private AtomicInteger count;
	public TaskDetail(AtomicInteger count){
		this.count = count;
	}
	
	@Override
	public void run() {
		System.err.println("--->mmmmm--->");
		System.err.println("--->test--> "+ Thread.currentThread().getName());
		this.count.addAndGet(1);
		System.err.println("--->sssss--->");
	}
	
}
