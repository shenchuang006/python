package com.ssm.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {
public static int add(){
	int result = 0;
	int i = 2;
	int j = 5;
	int c = 6;
	return result = (i + j) * c;
}
public static void main(String[] args) throws Exception {
	boolean isFlage = false;
	if(!isFlage){
		isFlage = true;
		System.err.println("11111");
	}else if(isFlage){
		System.err.println("--->");
	}
	final CountDownLatch latch = new CountDownLatch(10);
	ExecutorService executorServices = Executors.newFixedThreadPool(10);
	for(int i = 0;i < 10;i++){
		final int j = i;
		executorServices.execute(new Runnable() {
			@Override
			public void run() {
				System.err.println("----> " + j);
				latch.countDown();
			}
		});
	}
	latch.await();
	System.err.println("---结束---");
	 Map<String, Integer> mapCount = new HashMap<String, Integer>();
     for (int i = 0;i < 5;i++) {
         String key = ""+3;
         //0,1,2,3,4
         if(mapCount.get(key) != null){
             Integer count = mapCount.get(key) + i;
             mapCount.put(key,count);
         }else{
             mapCount.put(key,i);
         }
     }
     System.err.println(mapCount);
     
}
}
