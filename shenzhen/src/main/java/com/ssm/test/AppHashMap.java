package com.ssm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppHashMap {
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	private static ExecutorService executorService2 = Executors.newFixedThreadPool(2);
	private static CountDownLatch cdl = new CountDownLatch(2);
	private static CountDownLatch cdl2 = new CountDownLatch(2);
	public static void main(String[] args) throws Exception {
		//final Map<String, Integer> map = new ConcurrentHashMap<String,Integer>();
		//final Map<String, Integer> map1 = new HashMap<String,Integer>();
		//1.
//		for(int i = 1;i <= 3;i++){
//			final int j = i;
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					map.put(""+j, j);
//					//cdl.countDown();
//				}
//			});
//		}
		//System.err.println("--->1"+map);
		//2.
//		for(int i = 1;i < 6 ;i++){
//			final int j = i;
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					map.put("mm"+j, j);
//					//cdl.countDown();
//				}
//			});
//		}
		//System.err.println("--->2"+map);
		
		
//		for(int i = 1;i <= 3;i++){
//			final int j = i;
//			executorService2.execute(new Runnable() {
//				@Override
//				public void run() {
//					map1.put(""+j, j);
//					//cdl2.countDown();
//				}
//			});
//		}
		//System.err.println("--->3"+map1);
		//2.
//		for(int i = 1;i < 6 ;i++){
//			final int j = i;
//			executorService2.execute(new Runnable() {
//				@Override
//				public void run() {
//					map1.put("mmm"+j, j);
//					//cdl2.countDown();
//				}
//			});
//		}
		//System.err.println("--->4"+map1);
		//cdl.wait();
		//cdl2.wait();
		//Thread.sleep(10000);
		final Map<String, List<String>> map3 = new ConcurrentHashMap<String,List<String>>();
		for(int i = 1;i <= 3;i++){
			final int j = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					List<String> strs = map3.get(""+j);
					if(strs == null){
						strs = new ArrayList<String>();
						strs.add(""+j);
						map3.put(""+j, strs);
					}else{
						map3.get(""+j).add(""+j);
					}
				}
			});
		}
		System.err.println("--->5"+map3);
		//2.
		for(int i = 1;i < 6 ;i++){
			final int j = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					List<String> strs = map3.get("nn"+j);
					if(strs == null){
						strs = new ArrayList<String>();
						strs.add(""+j);
						map3.put("nn"+j, strs);
					}else{
						map3.get("nn"+j).add(""+j);
					}
				}
			});
		}
		Thread.sleep(10000);
		System.err.println("--->6"+map3);
	}

}
