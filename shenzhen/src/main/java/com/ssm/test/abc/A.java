package com.ssm.test.abc;

public class A {
	private String abc = "abc";
	public A (){
		System.err.println("a ---");
	}
	public static void main(String[] args) {
		new BC();
		A i = new A();
		int a = i.abc();
		System.err.println(a);
	}
	
	public int abc(){
		int i = 0;
		try{
			++i;
		}catch(Exception e){
			
		}finally{
			++i;
		}
		return ++i;
	}
}


class BC extends A {
	private static String m = "m";
	
	public BC (){
		System.err.println("bc...");
	}
	
}
