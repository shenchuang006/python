package com.ssm.test.thread;

public class Mythread extends Thread {
    @Override
    public void run(){
        System.out.println("1.继承Thread，启动调用start方法启动线程");
    }
}
