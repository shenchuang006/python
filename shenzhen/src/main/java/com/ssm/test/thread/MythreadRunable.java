package com.ssm.test.thread;

public class MythreadRunable implements Runnable {
    @Override
    public void run(){
        System.out.println("2.实现runnable接口，再 new Thread(new MythreadRunable()).start()来启动线程");
    }
}
