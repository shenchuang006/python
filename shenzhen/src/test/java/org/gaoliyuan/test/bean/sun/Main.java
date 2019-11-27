package org.gaoliyuan.test.bean.sun;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {  
    @SuppressWarnings("unused")  
    public static void main(String[] args) {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    } 
    @Test
    public void test(){
    	List<String> sendEmails = new ArrayList<String>();
		List<String> one = new ArrayList<String>();
		List<String> two = new ArrayList<String>();
		sendEmails = null;
		one = null;
		sendEmails = two;
		two = null;
		System.err.println(sendEmails + ":--:" + two);
    }
}  
