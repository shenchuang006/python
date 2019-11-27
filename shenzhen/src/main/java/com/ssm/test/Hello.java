package com.ssm.test;

class A {
	 
    static {
        System.out.print("1");
    }
    {
    	System.err.print("A");
    }
    
    public A() {
        System.out.print("2");
    }
}
 
class B extends A{
 
    static {
        System.out.print("a");
    }
    {
    	System.err.print("B");
    }
 
    public B() {
        System.out.print("b");
    }
}
 
public class Hello {
 
    public static void main(String[] args) {
        //A ab = new B();
        //ab = new B();
    	//new B();
    	Integer t = new Integer(9);
    	Integer s = new Integer(9);
    	Long n = new Long(9);
    	System.err.println(t.equals(s));
    	System.err.println(t.equals(n));
    	System.err.println(t.equals(9));
    	
    }
 
}