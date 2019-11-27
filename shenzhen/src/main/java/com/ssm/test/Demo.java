package com.ssm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class Demo {
	public static void main(String[] args) {
	    ExecutorService executorService =Executors.newFixedThreadPool(3);
	    final CountDownLatch cdl = new CountDownLatch(3);
	    executorService.execute(new Runnable() {
	        @Override
	        public void run() {
	            try {
	                function1();
	            } catch (Exception e) {
	                //异常处理
	                e.printStackTrace();
	            }
	            finally {
	                cdl.countDown();
	            }
	           // function1();
	        }
	    });

	    executorService.execute(new Runnable() {
	        @Override
	        public void run() {
	        	try{
	        		function2();
	        	}catch(Exception e){
	        		cdl.countDown();
	        	}
	        }
	    });

	    executorService.execute(new Runnable() {
	        @Override
	        public void run() {
	        	try{
	        		function3();
	        	}catch(Exception e){
	        		cdl.countDown();
	        	}
	        }
	    });


	    try {
	       cdl.await();
	        //cdl.await(20,TimeUnit.SECONDS);
	        System.out.println("三个执行线程结束");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("执行线程异常");
	    }
	    finally {
	        executorService.shutdown();
	        System.out.println("执行线程关闭");
	    }


	}

	private static void function1(){
	    //int i = 10/0;
	    System.out.println("方法一");
	}

	private static void function2(){
	    System.out.println("方法二");
	}

	private static void function3(){
	    System.out.println("方法三");
	}
	
	@Test
	public void test4() throws Exception{
		String params = "21:35:00,7,200";
		 String[] split = params.split( "," );
         SimpleDateFormat format = new SimpleDateFormat( "HH:mm:ss" );
         Date endTime = format.parse( split[0] );
         Integer beforeDay = Integer.valueOf( split[ 1 ] );
         Integer rows = Integer.valueOf( split[2] );
         Calendar parseTime = Calendar.getInstance();
         parseTime.setTime( endTime );

         Date now = new Date();
         //订单创建时间为昨天
         final Calendar today = Calendar.getInstance();
         today.setTime( now );
         System.err.println(today.get( Calendar.HOUR_OF_DAY ));
         System.err.println((parseTime.get( Calendar.HOUR_OF_DAY )+1));
         
         List<String> list = new ArrayList<String>();
         list.add("1");
         list.add("2");
         Iterator<String> iterable =  list.iterator();
         while(iterable.hasNext()){
        	 String strin = iterable.next();
        	 System.err.println(strin+",--"+iterable.hasNext());
         }
         Date date = new Date();
         System.err.println(date);
	}
	
	 
}
